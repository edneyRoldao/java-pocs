package com.feignstudy.demo.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message) {
        super(message);
    }

}
