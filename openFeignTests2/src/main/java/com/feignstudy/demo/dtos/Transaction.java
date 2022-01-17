package com.feignstudy.demo.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {

    private int count;
    private int total;
    private String currency;
    private MerchantTransaction merchant;

}
