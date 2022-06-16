package com.edn.csvreader;

import com.edn.csvreader.dto.ImageEventDTO;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:events.csv");

        List<ImageEventDTO> events = new CsvToBeanBuilder(new FileReader(file))
                .withSeparator(';')
                .withType(ImageEventDTO.class)
                .build()
                .parse();

        events.forEach(event -> {
            System.out.println("--------------------------------");
            System.out.println(event.getId());
            System.out.println(event.getPhoto());
        });
    }

}
