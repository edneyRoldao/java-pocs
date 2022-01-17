package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StepListener extends StepExecutionListenerSupport {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info(String.format("The step: %s ##has been STARTED##", stepExecution.getStepName()));
        super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info(String.format("The step: %s ##has been FINISHED##", stepExecution.getStepName()));
        return ExitStatus.COMPLETED;
    }

}
