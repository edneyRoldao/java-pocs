package com.feignstudy.demo.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;

public class ContatoMock {

    @SneakyThrows
    public static void setupMockContatoResponse(WireMockServer mockServer) {
        String b = StreamUtils.copyToString(
                ContatoMock.class.getClassLoader().getResourceAsStream("payload/get-contato-list.json"),
                Charset.defaultCharset());

        mockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/contatos"))
            .willReturn(WireMock.aResponse()
                .withStatus(HttpStatus.OK.value())
                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .withBody(b)));
    }

}
