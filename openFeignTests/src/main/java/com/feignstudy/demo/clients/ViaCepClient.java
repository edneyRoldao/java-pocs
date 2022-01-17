package com.feignstudy.demo.clients;

import com.feignstudy.demo.dtos.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep", url = "${app.viacep.host}")
public interface ViaCepClient {

    @GetMapping("/ws/{cep}/json/")
    AddressDTO getAddress(@PathVariable("cep") String cep);

}

