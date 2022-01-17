package com.feignstudy.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import static java.nio.charset.Charset.defaultCharset;

import static org.springframework.util.StreamUtils.copyToString;

public class ReportingApiMocks {

    public static void setupMockGetClientResponse(WireMockServer mockServer) throws IOException {
        String path = "payload/post-get-client-response.json";
        mockServer.stubFor(WireMock.get(WireMock.urlEqualTo("/api/v3/transaction"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(copyToString(ReportingApiMocks.class.getClassLoader().getResourceAsStream(path),
                                defaultCharset()))));
    }

}
