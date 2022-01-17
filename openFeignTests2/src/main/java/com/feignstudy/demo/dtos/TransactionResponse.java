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
public class TransactionResponse implements Serializable {
    private Merchant fx;
    private CustomerInfo customerInfo;
    private Merchant merchant;
    private Transaction transaction;
}
