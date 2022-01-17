package com.feignstudy.demo.config;

import com.feignstudy.demo.clients.ContatosApiClient;
import com.feignstudy.demo.dtos.ContatoDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@EnableFeignClients(clients = ContatosApiClient.class)
@RestController
@Configuration
@EnableAutoConfiguration
@RibbonClient(name = "test", configuration = RibbonConfig.class)
public class FeignConfig {

    @GetMapping("api/contatos/{id}")
    Optional<ContatoDTO> getContato(@PathVariable int id) {
        return Optional.of(new ContatoDTO());
    }

}
