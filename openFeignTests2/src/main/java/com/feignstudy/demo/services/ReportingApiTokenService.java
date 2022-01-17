package com.feignstudy.demo.services;

import com.feignstudy.demo.dtos.ReportingLoginResponse;

import java.util.Optional;

public interface ReportingApiTokenService {

    Optional<ReportingLoginResponse> getApiTokenAccess();

    Boolean isTokenNotExpired(ReportingLoginResponse response);

}
