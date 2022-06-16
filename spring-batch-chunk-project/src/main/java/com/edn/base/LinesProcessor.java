package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
@Configuration
public class LinesProcessor implements ItemProcessor<Line, Line> {

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        String t1 = (String) stepExecution.getJobExecution().getExecutionContext().get("test");
        String t2 = (String) stepExecution.getJobExecution().getExecutionContext().get("test2");
        log.info("BEFORE PROCESSOR - t1={} t2={}", t1, t2);
    }

    @Override
    public Line process(Line line) {
        long age = ChronoUnit.YEARS.between(line.getDob(), LocalDate.now());
        line.setAge(age);
        return line;
    }

}
