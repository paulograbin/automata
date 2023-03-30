package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.BuildProgressDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;


@Service
public class CloudPortalAPI
{
	private final Logger LOG = LoggerFactory.getLogger(CloudPortalAPI.class);

	private final RestTemplate restTemplate;
	private final String TOKEN = "Bearer %%TOKEN_PLACEHOLDER%%";
	private final String BASE_API_URL = "https://portalapi.commerce.ondemand.com/v2/subscriptions/%%SUBSCRIPTION_CODE_PLACEHODER%%/";

	public String subscriptionCode;
	public String apiToken;


	public CloudPortalAPI(@Value("${ccv2.subscriptionCode}") String subscriptionCode, @Value("${ccv2.api.token}") String apiToken)
	{
		this.apiToken = apiToken;
		this.subscriptionCode = subscriptionCode;

		final var replacedTokenString = makeToken();

		restTemplate = new RestTemplateBuilder()
				.defaultHeader("Authorization", replacedTokenString)
				.build();
	}

	private String makeToken()
	{
		return TOKEN.replace("%%TOKEN_PLACEHOLDER%%", apiToken);
	}

	public String makeBaseUrl(String baseUrl)
	{
		String replacedToken = baseUrl.replace("%%TOKEN_PLACEHOLDER%%", apiToken);
		return replacedToken.replace("%%SUBSCRIPTION_CODE_PLACEHODER%%", subscriptionCode);
	}

	public <T> T sendRequest(String urlPath, Class<T> returnType)
	{
		LOG.info("Sending request to server...");

		Instant start = Instant.now();

		String url = makeBaseUrl(BASE_API_URL);
		T forObject = restTemplate.getForObject(url + urlPath, returnType);

		long requestTime = Duration.between(start, Instant.now()).toMillis();

		LOG.info("Sever took {} ms to come back", requestTime);

		return forObject;
	}

	public <T> T sendPostRequest(String s, Object request, Class<T> responseType)
	{
		Instant start = Instant.now();

		String url = makeBaseUrl(BASE_API_URL);
		T response = restTemplate.postForObject(url + s, request, responseType);

		long requestTime = Duration.between(start, Instant.now()).toMillis();
		LOG.info("Sever took {} ms to come back", requestTime);

		return response;
	}

	public BuildProgressDTO getBuildProgress(String buildCode)
	{
		LOG.info("Sending request to server...");
		Instant start = Instant.now();

		String url = makeBaseUrl(BASE_API_URL);
		BuildProgressDTO forObject = restTemplate.getForObject(url + "/builds/" + buildCode + "/progress", BuildProgressDTO.class);

		long requestTime = Duration.between(start, Instant.now()).toMillis();

		LOG.info("Sever took {} ms to come back", requestTime);

		return forObject;
	}
}
