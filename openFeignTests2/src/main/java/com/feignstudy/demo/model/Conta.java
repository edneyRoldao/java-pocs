package com.feignstudy.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class Conta implements Serializable {

    private String nome;

}
