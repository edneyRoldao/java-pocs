package com.edn.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DiscountService implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private QueryUtils queryUtils;

    @Override
    public void run(String... args) throws Exception {
        DiscountFilterDTO filter = getFilter();
        List<DiscountDocument> documents = mongoTemplate.find(queryUtils.queryBuilder(filter), DiscountDocument.class);
        System.out.println(documents.size());
    }


    private static DiscountFilterDTO getFilter() {
        List<OperatorUnitEnum> units = new ArrayList<>();
        units.add(OperatorUnitEnum.PERCENT);

        List<String> serviceContractsIds = new ArrayList<>();
        serviceContractsIds.add("5db896d421d056000129f0e6");
        serviceContractsIds.add("5db896e021d05600012a010f");

        return DiscountFilterDTO.builder()
                .enabled(null)
                .validity(OffsetDateTime.from(LocalDateTime.now().atZone(ZoneOffset.of("-03:00"))))
                .serviceContractId("5d42a8b0afe2176b7aa794bd")
//                .serviceContractIds(serviceContractsIds)
                .unit(OperatorUnitEnum.RAW_VALUE)
                .units(units)
                .build();
    }



}
