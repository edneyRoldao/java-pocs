package com.feignstudy.demo.interceptors;

import com.feignstudy.demo.dtos.ReportingLoginResponse;
import com.feignstudy.demo.exceptions.SystemException;
import com.feignstudy.demo.services.ReportingApiTokenService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReportingApiInterceptor implements RequestInterceptor {

    private final ReportingApiTokenService service;
    private ReportingLoginResponse accessTokenResponseCache;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", getToken());
    }

    private String getToken() {
        if (shouldNotGetTokenFromCache()) {
            accessTokenResponseCache = service.getApiTokenAccess().orElseThrow(SystemException::new);
        }
        return accessTokenResponseCache.getToken();
    }

    private boolean isTokenNotBlank() {
        return Objects.nonNull(accessTokenResponseCache) && StringUtils.isNotBlank(accessTokenResponseCache.getToken());
    }

    private boolean shouldGetTokenFromCache() {
        return isTokenNotBlank() && service.isTokenNotExpired(accessTokenResponseCache);
    }

    private boolean shouldNotGetTokenFromCache() {
        return !shouldGetTokenFromCache();
    }

}
