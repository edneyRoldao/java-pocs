package com.edntisolutions.yamlstudy;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("teste.abc")
@EnableConfigurationProperties
public class ConfigProperties {

    private List<String> firstList;
    private List<String> secondList;
    private List<String> thirdList;
    private List<Float> fourthList;
    private List<Integer> fifthList;

}

