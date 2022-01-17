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
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j

public class LinesProcessor implements Tasklet, StepExecutionListener {

    private List<Line> lines;

    @Autowired
    private Props props;


    @Override
    @SuppressWarnings("unchecked")
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext context = stepExecution.getJobExecution().getExecutionContext();
        this.lines = (List<Line>) context.get("lines");
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        lines.forEach(l -> {
            long age = ChronoUnit.YEARS.between(l.getDob(), LocalDate.now());
            log.error("##########   {}   ###########", props.getA());
            log.info("Calculated age " + age + " for line " + l.toString());
            l.setAge(age);
        });

        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }

}
