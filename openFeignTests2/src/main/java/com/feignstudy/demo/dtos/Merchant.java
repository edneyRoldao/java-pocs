package com.feignstudy.demo.dtos;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {

    private int id;
    private String name;
    private int originalAmount;
    private String originalCurrency;

}

