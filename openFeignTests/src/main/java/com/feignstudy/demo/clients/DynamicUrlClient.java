package com.feignstudy.demo.clients;

import com.feignstudy.demo.dtos.ContatoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@FeignClient(value = "dynamicAPI", url = "placeholder")
public interface DynamicUrlClient {

    @GetMapping
    String getAddress(URI uri);

    @PostMapping
    String testPost(URI uri, @RequestBody ContatoDTO contatoDTO);

    @PostMapping
    void testPost2(URI uri, @RequestBody ContatoDTO contatoDTO);

}
