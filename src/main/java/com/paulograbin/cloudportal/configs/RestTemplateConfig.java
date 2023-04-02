package com.paulograbin.cloudportal.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class RestTemplateConfig {

    private final String TOKEN = "Bearer %%TOKEN_PLACEHOLDER%%";

    @Bean
    RestTemplate restTemplate(@Value("${ccv2.api.token}") String apiToken) {
        Proxy localhost = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8080));
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//
        simpleClientHttpRequestFactory.setProxy(localhost);

        final var replacedTokenString = makeToken(apiToken);

        return new RestTemplateBuilder()
                .defaultHeader("Authorization", replacedTokenString)
//                .requestFactory(() -> simpleClientHttpRequestFactory)
                .build();
    }

    private String makeToken(String apiToken) {
        return TOKEN.replace("%%TOKEN_PLACEHOLDER%%", apiToken);
    }
}
