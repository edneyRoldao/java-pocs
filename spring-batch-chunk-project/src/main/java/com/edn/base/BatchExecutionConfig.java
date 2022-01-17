package com.edn.base;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Configuration
public class BatchExecutionConfig {

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @Getter
    @Setter
    private AtomicBoolean enableJobExecution = new AtomicBoolean(true);

    @Scheduled(fixedRate = 600000)
    public void launchJobScheduler() throws Exception {
        if (enableJobExecution.get()) {
            Date startDate = new Date();
            JobExecution execution = jobLauncher.run(job, new JobParametersBuilder()
                    .addDate("launch date",  startDate)
                    .toJobParameters());
        }
    }

}
