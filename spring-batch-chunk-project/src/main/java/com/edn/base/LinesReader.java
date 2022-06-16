package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LinesReader implements ItemReader<Line> {

    private FileUtils utils;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        String t1 = (String) stepExecution.getJobExecution().getExecutionContext().get("test");
        String t2 = (String) stepExecution.getJobExecution().getExecutionContext().get("test2");
        log.info("BEFORE READER - t1={} t2={}", t1, t2);

        utils = new FileUtils("input/spring-batch.csv");
    }

    @Override
    public Line read() throws Exception {
        return utils.readLine();
    }

}
