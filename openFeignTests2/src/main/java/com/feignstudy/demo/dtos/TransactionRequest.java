package com.feignstudy.demo.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class TransactionRequest implements Serializable {
    private String transactionId;
}
