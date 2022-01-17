package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LinesReader implements Tasklet, StepExecutionListener {

    private List<Line> lines;
    private FileUtils utils;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        lines = new ArrayList<>();
        utils = new FileUtils("input/spring-batch.csv");
    }

    @Override
    public RepeatStatus execute(StepContribution step, ChunkContext chunk) throws Exception {
        Line line = utils.readLine();

        while (line != null) {
            lines.add(line);
            log.info("read line: " + line.toString());
            line = utils.readLine();
        }

        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        utils.closeReader();
        stepExecution
                .getJobExecution()
                .getExecutionContext()
                .put("lines", this.lines);
        return ExitStatus.COMPLETED;
    }

}
