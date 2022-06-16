package com.edn.base;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobListener extends JobExecutionListenerSupport {

    @Override
    @SneakyThrows
    public void beforeJob(JobExecution jobExecution) {
        log.info("@@@@@@@@@@ JOB LISTENER (before) @@@@@@@@@@@");
        log.info("Starting job ID={} NAME={}.", jobExecution.getJobId(), jobExecution.getJobInstance().getJobName());

        jobExecution.getExecutionContext().put("test", "just a test:" + jobExecution.getJobId());
        Thread.sleep(1000);
        jobExecution.getExecutionContext().put("test2", "just a second test:" + jobExecution.getJobId());


        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(this);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
    }

}
