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
public class TransactionQueryRequest implements Serializable {

    private String fromDate;
    private String toDate;
    private int merchantId;
    private int acquirerId;
    private String status;
    private String operation;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private String page;

}
