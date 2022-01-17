package com.feignstudy.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO implements Serializable {

    private int id;
    private String nome;
    private String tipo;
    private String valor;

}
