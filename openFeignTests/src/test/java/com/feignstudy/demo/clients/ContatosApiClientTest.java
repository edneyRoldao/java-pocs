package com.feignstudy.demo.clients;

import com.feignstudy.demo.config.WireMockConfig;
import com.feignstudy.demo.mock.ContatoMock;
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

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
public class ContatosApiClientTest {

    @Autowired
    private WireMockServer mockContatoServer;

    @Autowired
    private ContatosApiClient contatosApiClient;

    @BeforeEach
    void setup() {
        ContatoMock.setupMockContatoResponse(mockContatoServer);
    }

    @Test
    void test() {
        Assertions.assertFalse(contatosApiClient.contatosFilter("").isEmpty());
    }

}
