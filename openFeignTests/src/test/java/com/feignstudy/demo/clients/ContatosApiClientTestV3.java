package com.feignstudy.demo.clients;

import com.feignstudy.demo.config.FeignConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FeignConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContatosApiClientTestV3 {

    @Autowired
    ContatosApiClient client;

    @Test
    public void test() {
        Assertions.assertFalse(client.getContato(1).isPresent());
    }

}
