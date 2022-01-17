package com.feignstudy.demo.config;

import com.feignstudy.demo.exceptions.BadRequestException;
import com.feignstudy.demo.exceptions.NotFoundException;
import com.feignstudy.demo.exceptions.InternalServerErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorHandlerDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 500:
                return new InternalServerErrorException("a system error happened");
            case 400:
                return new BadRequestException("the request isn correct");
            case 404:
                return new NotFoundException("resource not found");
            default:
                return new Exception("error unhandled");
        }
    }

}
