package com.feignstudy.demo.clients;

import com.feignstudy.demo.dtos.OrderStatusNotificationDTO;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "partnerAPI", url = "${partnerAPI.host}")
public interface PartnerClient {

    @PostMapping
    Response testPost(@RequestHeader("abasteceai-signature") String signature,
                      @RequestBody OrderStatusNotificationDTO body);

}
