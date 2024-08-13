package com.paulograbin.cloudportal.ccv2;

import com.google.gson.Gson;
import com.paulograbin.cloudportal.ccv2.v1dto.CustomersDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.PermissionDTO;
import com.paulograbin.cloudportal.web.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;


@Service
public class OlderAPIService {

    private final Logger LOG = LoggerFactory.getLogger(CloudPortalAPI.class);

    public String subscriptionCode;
    public String apiToken;

    private final RestTemplate restTemplate;

    private final String TOKEN = "Bearer %%TOKEN_PLACEHOLDER%%";
    private final String BASE_API_URL = "https://portalapi.commerce.ondemand.com/v1/subscriptions/%%SUBSCRIPTION_CODE_PLACEHODER%%/";
    private final String BASE_API_URL_ANOTHER = "https://portalapi.commerce.ondemand.com/v1/";

    private final ConfigurationService configurationService;


    public OlderAPIService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
        this.apiToken = this.configurationService.loadConfiguration().getAuthenticationToken();
        this.subscriptionCode = this.configurationService.loadConfiguration().getSubscriptionCode();

        final var replacedTokenString = makeToken();

        restTemplate = new RestTemplateBuilder()
                .defaultHeader("Authorization", replacedTokenString)
                .build();
    }

    private String makeToken() {
        return TOKEN.replace("%%TOKEN_PLACEHOLDER%%", apiToken);
    }


    public String makeBaseUrl(String baseUrl) {
        return baseUrl.replace("%%SUBSCRIPTION_CODE_PLACEHODER%%", subscriptionCode);
    }

    public void applyConfigurationsToEnvironment(String environmentCode) {
        applyPropertiesInternal(environmentCode);
    }

    private void applyPropertiesInternal(String environmentCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json, text/plain, */*");
        headers.set("accept-language", "en,en-US;q=0.9");
        headers.set("content-type", "application/json");
        headers.set("origin", "https://portal.commerce.ondemand.com");

        HttpEntity<String> entity = new HttpEntity<>("{}", headers);
        Instant start = Instant.now();

        String url = makeBaseUrl("https://portal.commerce.ondemand.com/v1/subscriptions/%%SUBSCRIPTION_CODE_PLACEHODER%%/environments/d1/applyconfiguration");

        try {
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            LOG.info("Apply properties successful with code {}", exchange.getStatusCode());
        } catch (HttpClientErrorException e) {
            LOG.info("Apply properties response failed with status code {}", e.getStatusCode());
        }

        long requestTime = Duration.between(start, Instant.now()).toMillis();
        LOG.debug("Sever took {} ms to come back", requestTime);
    }


    public void getPermissions() {
        LOG.info("Sending GET permissions request...");
        PermissionDTO permissions = sendRequestInternalOlderAPITyped("permissions", PermissionDTO.class);

        LOG.info("Get permissions response {}", permissions);
    }

    public void getCurrentUser() {
        LOG.info("Sending GET user request...");
        CurrentUserDTO userResponse = sendRequestInternalOlderAPITyped("currentuser", CurrentUserDTO.class);

        LOG.info("Get current user {}", userResponse);
    }

    public void getCustomers() {
        LOG.info("Sending GET customer request...");
        var customerResponse = getCustomers("customers");

        LOG.info("Get customers returned {} entries", customerResponse.size());
    }

    private List<CustomersDTO> getCustomers(String urlPath) {
        Instant start = Instant.now();

        String url = makeBaseUrl(BASE_API_URL_ANOTHER);
        String olderAPIReturn = restTemplate.getForObject(url + urlPath, String.class);

        long requestTime = Duration.between(start, Instant.now()).toMillis();
        LOG.debug("Sever took {} ms to come back", requestTime);

        Gson gson = new Gson();
        CustomersDTO[] customers = gson.fromJson(olderAPIReturn, CustomersDTO[].class);

        return Arrays.asList(customers);
    }

    private <T> T sendRequestInternalOlderAPITyped(String urlPath, Class<T> returnType) {
        Instant start = Instant.now();

        String url = makeBaseUrl(BASE_API_URL_ANOTHER);
        String olderAPIReturn = restTemplate.getForObject(url + urlPath, String.class);

        long requestTime = Duration.between(start, Instant.now()).toMillis();
        LOG.debug("Sever took {} ms to come back", requestTime);

        Gson gson = new Gson();
        return gson.fromJson(olderAPIReturn, returnType);
    }
}
