package com.feignstudy.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransactionQueryResp implements Serializable {

    @JsonProperty("per_page")
    private int pageSize;

    @JsonProperty("current_page")
    private int page;

    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    private int from;

    private int to;

    List<TransactionQuery> data;

}
