package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Slf4j
@Configuration
public class LinesReader implements ItemReader<Line> {

    private FileUtils utils;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        utils = new FileUtils("input/spring-batch.csv");
        log.info("line reader starts");
    }

    @Override
    public Line read() throws Exception {
        Line line = utils.readLine();

        if (Objects.nonNull(line))
            log.info("read line: " + line.toString());

        return line;
    }

}
