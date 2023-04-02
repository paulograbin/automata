package com.paulograbin.cloudportal.ccv2;

import com.google.gson.Gson;
import com.paulograbin.ccv2api.model.BuildDetailDTO;
import com.paulograbin.ccv2api.model.BuildDetailsDTO;
import com.paulograbin.ccv2api.model.BuildProgressDTO;
import com.paulograbin.ccv2api.model.CreateBuildRequestDTO;
import com.paulograbin.ccv2api.model.CreateBuildResponseDTO;
import com.paulograbin.ccv2api.model.CreateDatabackupResponseDTO;
import com.paulograbin.ccv2api.model.CreateDatarestoreResponseDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentDecisionResponseDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentRequestDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentResponseDTO;
import com.paulograbin.ccv2api.model.DatabackupDetailDTO;
import com.paulograbin.ccv2api.model.DatabackupDetailsDTO;
import com.paulograbin.ccv2api.model.DatarestoreDetailDTO;
import com.paulograbin.ccv2api.model.DatarestoreDetailsDTO;
import com.paulograbin.ccv2api.model.DeploymentDecisionsDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
import com.paulograbin.ccv2api.model.DeploymentModeDTO;
import com.paulograbin.ccv2api.model.DeploymentProgressDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;


@Service
//@Profile("production")
@Profile("development")
public class CloudPortalAPI implements CloudPortalOperations {

    private final Logger LOG = LoggerFactory.getLogger(CloudPortalAPI.class);

    private final RestTemplate restTemplate;
    private final String TOKEN = "Bearer %%TOKEN_PLACEHOLDER%%";
    private final String BASE_API_URL = "http://localhost:8080/v2/subscriptions/%%SUBSCRIPTION_CODE_PLACEHODER%%/";

    public String subscriptionCode;
    public String apiToken;


    public CloudPortalAPI(@Value("${ccv2.subscriptionCode}") String subscriptionCode, @Value("${ccv2.api.token}") String apiToken) {
        this.apiToken = apiToken;
        this.subscriptionCode = subscriptionCode;

        final var replacedTokenString = makeToken();

        Proxy localhost = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8080));
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//
        simpleClientHttpRequestFactory.setProxy(localhost);

        restTemplate = new RestTemplateBuilder()
                .defaultHeader("Authorization", replacedTokenString)
//                .requestFactory(() -> simpleClientHttpRequestFactory)
                .build();
    }

    private String makeToken() {
        return TOKEN.replace("%%TOKEN_PLACEHOLDER%%", apiToken);
    }

    public String makeBaseUrl(String baseUrl) {
        String replacedToken = baseUrl.replace("%%TOKEN_PLACEHOLDER%%", apiToken);
        return replacedToken.replace("%%SUBSCRIPTION_CODE_PLACEHODER%%", subscriptionCode);
    }


    @Override
    public <T> T sendPostRequest(String s, Object request, Class<T> responseType) {
        Instant start = Instant.now();

        String url = makeBaseUrl(BASE_API_URL);
        T response = restTemplate.postForObject(url + s, request, responseType);

        long requestTime = Duration.between(start, Instant.now()).toMillis();
        LOG.info("Sever took {} ms to come back", requestTime);

        return response;
    }

    @Override
    public BuildProgressDTO getBuildProgress(String buildCode) {
        LOG.info("Sending request to server...");
        Instant start = Instant.now();

        String url = makeBaseUrl(BASE_API_URL);
        BuildProgressDTO forObject = restTemplate.getForObject(url + "/builds/" + buildCode + "/progress", BuildProgressDTO.class);

        long requestTime = Duration.between(start, Instant.now()).toMillis();

        LOG.info("Sever took {} ms to come back", requestTime);

        return forObject;
    }


    public BuildDetailsDTO getAllBuilds() {
        return sendRequestInternal("builds", BuildDetailsDTO.class);
    }

    @Override
    @Cacheable("build")
    public BuildDetailDTO getBuild(String code) {
        return sendRequestInternal(code, BuildDetailDTO.class);
    }

    @Override
    public CreateBuildResponseDTO createBuild(CreateBuildRequestDTO requestDTO) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getBuildLogs(String buildCode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public DeploymentDetailsDTO getDeployments(String deployments) {
        return sendRequestInternal(deployments, DeploymentDetailsDTO.class);
    }

    @Override
    public DeploymentDetailDTO getDeployment(String deployments) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CreateDeploymentResponseDTO createDeployment(CreateDeploymentRequestDTO deploymentRequestDTO) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CreateDeploymentDecisionResponseDTO createDeploymentDecision(CreateDeploymentDecisionResponseDTO responseDTO) {
        throw new UnsupportedOperationException();
    }

    @Override
    public DeploymentDecisionsDTO getDeploymentDecisions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DeploymentModeDTO getDeploymentModes() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DeploymentProgressDTO getDeploymentProgress() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CreateDatabackupResponseDTO createDataBackup() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CreateDatarestoreResponseDTO createDataRestore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DatabackupDetailDTO getDataBackup() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DatabackupDetailsDTO getDataBackups() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DatarestoreDetailDTO getDataRestore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DatarestoreDetailsDTO getDataRestores() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DeploymentDetailsDTO getDeployments(String deployments, Map<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder();

        params.forEach((name, values) -> {

            if (queryBuilder.isEmpty()) {
                queryBuilder.append("?");
                queryBuilder.append(name);
                queryBuilder.append("=");
                queryBuilder.append(values);
            } else {
                queryBuilder.append("&");
                queryBuilder.append(name);
                queryBuilder.append("=");
                queryBuilder.append(values);
            }
        });

        return sendRequestInternal(deployments + '/' + queryBuilder, DeploymentDetailsDTO.class);
    }

    private <T> T sendRequestInternal(String urlPath, Class<T> returnType) {
        LOG.info("Sending request to server...");

        Instant start = Instant.now();

        String url = makeBaseUrl(BASE_API_URL);
        T forObject = restTemplate.getForObject(url + urlPath, returnType);

        long requestTime = Duration.between(start, Instant.now()).toMillis();

        LOG.info("Sever took {} ms to come back", requestTime);

        return forObject;
    }




    public EnvironmentsDTO fetchEnvironments() {
        EnvironmentsDTO environments = sendRequestInternalOlderAPI("environments");

        for (EnvironmentDTO environment : environments.getValue()) {
            LOG.info("Found environment {}", environment);
        }
        return environments;
    }

    private EnvironmentsDTO sendRequestInternalOlderAPI(String urlPath) {
        LOG.info("Sending request to server...");

        Instant start = Instant.now();

        String url = makeBaseUrl(BASE_API_URL);
        url = url.replace("v2", "v1");
        String olderAPIReturn = restTemplate.getForObject(url + urlPath, String.class);

        olderAPIReturn = "{ \"value\":" + olderAPIReturn + '}';

        long requestTime = Duration.between(start, Instant.now()).toMillis();

        LOG.info("Sever took {} ms to come back", requestTime);

        Gson gson = new Gson();
        return gson.fromJson(olderAPIReturn, EnvironmentsDTO.class);
    }
}
