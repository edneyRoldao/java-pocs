package com.feignstudy.demo.clients;

import com.feignstudy.demo.dtos.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(value = "reportingApiClient", url = "${reporting-api-client.host}")
public interface ReportingApiClient {

    @PostMapping("/api/v3/transactions/report")
    Optional<TransactionReportResponse> transactionReport(@RequestBody TransactionReportRequest request);

    @PostMapping("/api/v3/transaction/list")
    Optional<TransactionQueryResp> transactionQuery(@RequestBody TransactionQueryRequest request);

    @PostMapping("/api/v3/transaction")
    Optional<TransactionResponse> getTransaction(@RequestBody TransactionRequest request);

    @PostMapping("/api/v3/transaction")
    Optional<CustomerInfo> getClient(@RequestBody TransactionRequest request);

}
