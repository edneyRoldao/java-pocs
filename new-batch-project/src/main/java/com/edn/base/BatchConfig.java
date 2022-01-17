package com.edn.base;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@EnableAsync
@Configuration
@EnableScheduling
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Getter
    private final AtomicInteger batchRunCounter = new AtomicInteger(0);

    @Getter
    @Setter
    private AtomicBoolean enableJobExecution = new AtomicBoolean(true);

    @Async
    @Scheduled(fixedRate = 60000)
    public void launchJobScheduler() throws Exception {
        if (enableJobExecution.get()) {
            Date startDate = new Date();
            log.info("Scheduler starts at " + startDate);

            JobExecution execution = jobLauncher.run(job(), new JobParametersBuilder()
                    .addDate("launch date",  startDate)
                    .toJobParameters());

            Integer jobNumber = batchRunCounter.incrementAndGet();
            log.debug("Batch job {}, ends with status as {}", jobNumber, execution.getStatus());
        }
    }

    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }

    @Bean
    public Job job() {
        return jobs
                .get("taskletJob")
                .start(readLines())
                .next(processLines())
                .next(writeLines())
                .build();
    }

    @Bean
    protected Step readLines() {
        return steps
                .get("readLines")
                .tasklet(linesReader())
                .build();
    }

    @Bean
    protected Step processLines() {
        return steps
                .get("processLines")
                .tasklet(linesProcessor())
                .build();
    }

    @Bean
    protected Step writeLines() {
        return steps
                .get("writeLines")
                .tasklet(linesWriter())
                .build();
    }

    @Bean
    public LinesWriter linesWriter() {
        return new LinesWriter();
    }

    @Bean
    public LinesProcessor linesProcessor() {
        return new LinesProcessor();
    }

    @Bean
    public LinesReader linesReader() {
        return new LinesReader();
    }

}
