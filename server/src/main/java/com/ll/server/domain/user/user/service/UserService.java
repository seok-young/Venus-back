package com.ll.server.domain.user.user.service;

import com.ll.server.domain.user.user.entity.User;
import com.ll.server.domain.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserService {
    @Value("${spring.oauth.naver.client_id}")
    private String clientId;

    @Value("${spring.oauth.naver.client_secret}")
    private String clientSecret;

    @Value("${spring.oauth.naver.request-token-uri}")
    private String requestTokenUri;

    @Value("${spring.oauth.naver.redirect_uri}")
    private String redirectUri;

    public void printValues() {
        System.out.println("Client ID: " + clientId);
        System.out.println("Client Secret: " + clientSecret);
        System.out.println("Request Token URI: " + requestTokenUri);
        System.out.println("Redirect URI: " + redirectUri);
    }


    public String getNaverAuthorizeUrl(String type) throws Exception {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(requestTokenUri)
                .pathSegment(type)
                .queryParam("response_type", "code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", URLEncoder.encode(redirectUri, StandardCharsets.UTF_8.toString()))
                .queryParam("state", URLEncoder.encode("1234", StandardCharsets.UTF_8.toString()))
                .build();

        return uriComponents.toString();
    }
    }

