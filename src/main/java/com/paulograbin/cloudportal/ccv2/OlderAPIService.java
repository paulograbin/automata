package com.paulograbin.cloudportal.ccv2;

import com.google.gson.Gson;
import com.paulograbin.cloudportal.ccv2.v1dto.CustomersDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.PermissionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;


@Service
public class OlderAPIService {

    private final Logger LOG = LoggerFactory.getLogger(CloudPortalAPI.class);

    public String subscriptionCode;
    public String apiToken;

    private final RestTemplate restTemplate;

    private final String TOKEN = "Bearer %%TOKEN_PLACEHOLDER%%";
    private final String BASE_API_URL = "https://portalapi.commerce.ondemand.com/v1/subscriptions/%%SUBSCRIPTION_CODE_PLACEHODER%%/";
    private final String BASE_API_URL_ANOTHER = "https://portalapi.commerce.ondemand.com/v1/";


    public OlderAPIService(@Value("${ccv2.subscriptionCode}") String subscriptionCode, @Value("${ccv2.api.token}") String apiToken) {
        this.apiToken = apiToken;
        this.subscriptionCode = subscriptionCode;

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
        CustomersDTO customerResponse = sendRequestInternalOlderAPITyped("customers", CustomersDTO.class);

        LOG.info("Get customers {}", customerResponse);
    }

    private <T> T sendRequestInternalOlderAPITyped(String urlPath, Class<T> returnType) {
        Instant start = Instant.now();

        String url = makeBaseUrl(BASE_API_URL_ANOTHER);
        String olderAPIReturn = restTemplate.getForObject(url + urlPath, String.class);

        long requestTime = Duration.between(start, Instant.now()).toMillis();
        LOG.debug("Sever took {} ms to come back", requestTime);

        if (urlPath.equalsIgnoreCase("customers")) {
            olderAPIReturn = "{ \"value\":" + olderAPIReturn + '}';
        }

        Gson gson = new Gson();
        return gson.fromJson(olderAPIReturn, returnType);
    }
}
