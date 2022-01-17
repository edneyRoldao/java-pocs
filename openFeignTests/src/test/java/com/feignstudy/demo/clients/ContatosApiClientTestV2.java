package com.feignstudy.demo.clients;

import com.feignstudy.demo.dtos.ContatoDTO;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.requireNonNull;

@SpringBootTest
public class ContatosApiClientTestV2 {

    @Autowired
    private ContatosApiClient client;

    private static final String BASE_URL = "http://localhost:3000";
    private final ClassLoader classLoader = this.getClass().getClassLoader();


    @Test
    @SneakyThrows
    public void test() {
//        String doc = "aaaaaaaaaaaaaaaa";
//        String b = loadFile("get-contato-list");
//
//        builderFeignClient(new MockClient().ok(HttpMethod.GET, BASE_URL.concat("/api/contatos/doc/{doc}"), b));
//
//        List<ContatoDTO> list = client.contatosFilter(doc);
//
//        Assertions.assertFalse(list.isEmpty());
    }


    private void builderFeignClient(MockClient mockClient) {
        client = Feign
                .builder()
                .client(mockClient)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .target(ContatosApiClient.class, BASE_URL);
    }

    protected  String loadFile(String jsonName) {
        try {
            final String ROOT_PATH = "payload/%s.json";

            File file = new File(requireNonNull(classLoader
                    .getResource(String.format(ROOT_PATH, jsonName))).getPath());
            return FileUtils.readFileToString(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
