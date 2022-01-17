package com.edn.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
@Configuration
public class LinesProcessor implements ItemProcessor<Line, Line> {

    @Override
    public Line process(Line line) throws Exception {
        long age = ChronoUnit.YEARS.between(line.getDob(), LocalDate.now());
        line.setAge(age);

        log.info("Calculated age " + age + " for line " + line.toString());

        return line;
    }

}
