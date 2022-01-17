package com.feignstudy.demo.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReportingLoginRequest implements Serializable {

    private String email;
    private String password;

}
