package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableAsync
@Configuration
@EnableScheduling
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private StepListener stepListener;

    @Autowired
    private JobListener jobListener;

    @Autowired
    private ItemReader<Line> itemReader;

    @Autowired
    ItemProcessor<Line, Line> itemProcessor;

    @Autowired
    ItemWriter<Line> itemWriter;

    @Bean
    public Job job() {
        return jobs
                .get("chunksJob")
                .start(processLines(itemReader, itemProcessor, itemWriter))
                .listener(jobListener)
                .build();
    }

    @Bean
    protected Step processLines(ItemReader<Line> r, ItemProcessor<Line, Line> p, ItemWriter<Line> w) {
        return steps.get("processLines").<Line, Line>chunk(0)
                .reader(r)
                .processor(p)
                .writer(w)
                .taskExecutor(asyncTaskExecutor())
                .listener(stepListener)
                .build();
    }

    @Bean
    public TaskExecutor asyncTaskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor("linesProcessorTaskExecutor");
        taskExecutor.setConcurrencyLimit(8);
        return taskExecutor;
    }

}
