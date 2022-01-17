package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

@Slf4j
@Configuration
public class LinesWriter implements ItemWriter<Line> {

    private FileUtils utils;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        Random random = new Random();
        utils = new FileUtils(String.format("/home/edney/dootax/%s-output.csv", random.nextInt(10000)));
    }

    @Override
    public void write(List<? extends Line> lines) throws Exception {
        log.error("@@@@@@@@@@@@@@@@@ [[[[[[[   {}   ]]]]]]]] @@@@@@@@@@@@@@", lines.size());

        lines.forEach(l -> {
            utils.writeLine(l);
            log.debug("Wrote line " + l.toString());
        });
    }

}
