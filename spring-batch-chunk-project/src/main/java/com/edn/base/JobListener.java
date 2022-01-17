package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobListener extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Starting job ID={} NAME={}.", jobExecution.getJobId(), jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Finishing job ID={} NAME={}. The job took {} second(s) to complete.",
                jobExecution.getJobId(),
                jobExecution.getJobInstance().getJobName(),
                (jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime())/1000
        );

        log.info("Finishing job ID={} NAME={}.", jobExecution.getJobId(), jobExecution.getJobInstance().getJobName());
    }
}
