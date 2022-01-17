package com.feignstudy.demo.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class AddressDTO {

    private String cep;
    private String logradouro;
    private String localidade;
    private String uf;

}
