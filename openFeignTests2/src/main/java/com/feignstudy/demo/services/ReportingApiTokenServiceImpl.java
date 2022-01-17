package com.feignstudy.demo.services;

import com.feignstudy.demo.dtos.ReportingLoginRequest;
import com.feignstudy.demo.dtos.ReportingLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpMethod.POST;


@Service
@RequiredArgsConstructor
public class ReportingApiTokenServiceImpl implements ReportingApiTokenService {

    @Value("${reporting-api-client.host}")
    private String host;

    @Value("${reporting-api-client.merchant-login}")
    private String merchantLogin;

    @Value("${reporting-api-client.merchant-password}")
    private String merchantPassword;

    @Value("${reporting-api-client.token-expiration-time}")
    private Integer minTokenExpirationTime;

    private final RestTemplate restTemplate;


    @Override
    public Optional<ReportingLoginResponse> getApiTokenAccess() {
        String url = String.format("%s/api/v3/merchant/user/login", host);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ReportingLoginRequest request = ReportingLoginRequest
                .builder()
                .email(merchantLogin)
                .password(merchantPassword)
                .build();

        HttpEntity<ReportingLoginRequest> requestBody = new HttpEntity<>(request, headers);

        ResponseEntity<ReportingLoginResponse> response =
                restTemplate.exchange(url, POST, requestBody, ReportingLoginResponse.class);

        ReportingLoginResponse loginResponse = response.getBody();
        setExpirationTimeToToken(loginResponse);

        return Optional.ofNullable(response.getBody());
    }

    @Override
    public Boolean isTokenNotExpired(ReportingLoginResponse response) {
        LocalDateTime expirationTime = response.getTokenExpirationTime();
        LocalDateTime now = LocalDateTime.now();
        return expirationTime.isBefore(now.minusMinutes(1));
    }

    private void setExpirationTimeToToken(ReportingLoginResponse response) {
        if (Objects.nonNull(response)) {
            response.setTokenExpirationTime(LocalDateTime.now().plusMinutes(minTokenExpirationTime));
        }
    }

}
