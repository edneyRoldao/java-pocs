package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class LinesWriter implements ItemWriter<Line> {

    private FileUtils utils;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        String t1 = (String) stepExecution.getJobExecution().getExecutionContext().get("test");
        String t2 = (String) stepExecution.getJobExecution().getExecutionContext().get("test2");
        log.info("BEFORE WRITER - t1={} t2={}", t1, t2);

        Random random = new Random();
        utils = new FileUtils(String.format("/home/edneyroldao/workspace/temp/batch-tests/%s-output.csv", random.nextInt(10000)));
    }


    @Override
    public void write(List<? extends Line> lines) throws Exception {
        lines.forEach(l -> utils.writeLine(l));
    }

}
