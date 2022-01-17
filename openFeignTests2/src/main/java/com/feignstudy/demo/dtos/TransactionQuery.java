package com.feignstudy.demo.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransactionQuery implements Serializable {
    private Merchant fx;
    private CustomerInfo customerInfo;
    private Merchant merchant;
    private Ipn ipn;
    private Transaction transaction;
    private Acquirer acquirer;
    private boolean refundable;
}

@Data
@EqualsAndHashCode
class Ipn implements Serializable {
    private boolean received;
}
