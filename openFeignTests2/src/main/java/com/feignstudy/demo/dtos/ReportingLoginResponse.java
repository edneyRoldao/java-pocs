package com.feignstudy.demo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReportingLoginResponse implements Serializable {

    private String token;
    private String status;

    @JsonIgnore
    private LocalDateTime tokenExpirationTime;

}
