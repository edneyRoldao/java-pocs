package com.feignstudy.demo.controller;

import com.feignstudy.demo.model.Conta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conta")
public class ContaController {

    @PostMapping
    public String testeValidador(@RequestBody Conta conta) {
        return conta.getNome();
    }

}
