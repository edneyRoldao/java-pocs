package com.feignstudy.demo;

import com.feignstudy.demo.clients.ReportingApiClient;
import com.feignstudy.demo.dtos.TransactionRequest;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.Objects;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
public class ReportingApiIntegrationTest {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    private ReportingApiClient reportingApiClient;

    @BeforeEach
    void setup() throws IOException {
        ReportingApiMocks.setupMockGetClientResponse(wireMockServer);
    }

    @Test
    public void whenGetClient_thenCustomerInfoShouldBeReturned() {
        if (Objects.isNull(reportingApiClient)) {
            System.out.println("I am null");
        }

        TransactionRequest request = new TransactionRequest();
        Assertions.assertTrue(reportingApiClient.getClient(request).isPresent());
    }

}
