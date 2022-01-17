package com.feignstudy.demo.config;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

@TestConfiguration
@ActiveProfiles("ribbon-test")
public class RibbonConfig {

    @LocalServerPort
    int port;

    @Bean
    public ServerList<Server> serverList() {
        return new StaticServerList<>(new Server("localhost", port), new Server("localhost", port));
    }

}
