package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.List;
import java.util.Random;

@Slf4j
public class LinesWriter implements Tasklet, StepExecutionListener {

    private List<Line> lines;
    private FileUtils utils;

    @Override
    @SuppressWarnings("unchecked")
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext context = stepExecution.getJobExecution().getExecutionContext();
        this.lines = (List<Line>) context.get("lines");
        Random random = new Random();
        utils = new FileUtils(String.format("/home/edney/%s-output.csv", random.nextInt(10000)));
    }

    @Override
    public RepeatStatus execute(StepContribution step, ChunkContext chunk) throws Exception {
        lines.forEach(l -> {
            utils.writeLine(l);
            log.debug("Wrote line " + l.toString());
        });
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        utils.closeWriter();
        return ExitStatus.COMPLETED;
    }

}
