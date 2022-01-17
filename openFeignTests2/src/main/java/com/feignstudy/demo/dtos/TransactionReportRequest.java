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
public class TransactionReportRequest implements Serializable {

    private String fromDate;
    private String toDate;
    private int merchant;
    private int acquirer;

}
