package com.edntisolutions.yamlstudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("test")
public class TesteYalm {

    private final ConfigProperties properties;

    @Autowired
    public TesteYalm(ConfigProperties properties) {
        this.properties = properties;
    }

    @GetMapping("f")
    public List<String> getYalmList() {
        return properties.getFirstList();
    }

    @GetMapping("s")
    public List<String> getYalmList2() {
        log.info("teste sl4J");
        return properties.getSecondList();
    }

    @GetMapping("t")
    public List<String> getYalmList3() {
        log.error("there was an error");
        return properties.getThirdList();
    }

    @GetMapping("f4")
    public List<Float> getYalmList4() {
        log.error("there was an error");
        return properties.getFourthList();
    }

    @GetMapping("f5")
    public List<Integer> getYalmList5() {
        log.error("there was an error");
        return properties.getFifthList();
    }

}
