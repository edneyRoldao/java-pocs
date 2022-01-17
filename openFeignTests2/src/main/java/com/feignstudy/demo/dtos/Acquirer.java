package com.feignstudy.demo.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Acquirer implements Serializable {

    private int id;
    private String name;
    private String code;
    private String type;

}

