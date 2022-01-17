package com.feignstudy.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MerchantTransaction implements Serializable {

    private int id;
    private int merchantId;
    private int agentInfoId;
    private int fxTransactionId;
    private int acquirerTransactionId;
    private String referenceNo;
    private String status;
    private String operation;
    private String message;
    private String channel;
    private String customData;
    private String chainId;
    private String code;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    private String transactionId;

}

