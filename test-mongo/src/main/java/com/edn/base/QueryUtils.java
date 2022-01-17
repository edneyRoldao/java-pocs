package com.edn.base;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class QueryUtils {

    public Query queryBuilder(DiscountFilterDTO filter) {
        Query query = new Query();

        Optional.ofNullable(filter.getEnabled()).ifPresent(enabled ->
                query.addCriteria(Criteria.where("enabled").is(enabled))
        );

        Optional.ofNullable(filter.getServiceContractId()).ifPresent(serviceContractId -> {
            if (Objects.isNull(filter.getServiceContractIds())) {
                filter.setServiceContractIds(new ArrayList<>());
            }

            filter.getServiceContractIds().add(serviceContractId);
        });

        Optional.ofNullable(filter.getUnit()).ifPresent(unit -> {
            if (Objects.isNull(filter.getUnits())) {
                filter.setUnits(new ArrayList<>());
            }
            filter.getUnits().add(unit);
        });

        Optional.ofNullable(filter.getUnits()).ifPresent(units ->
                query.addCriteria(Criteria.where("configuration.unit").in(units))
        );

        Optional.ofNullable(filter.getServiceContractIds()).ifPresent(contracts -> {
                List<ObjectId> contractsIds =  contracts.stream().map(ObjectId::new).collect(Collectors.toList());
                query.addCriteria(Criteria.where("serviceContractId").in(contractsIds));
            }
        );

        Optional.ofNullable(filter.getValidity()).ifPresent( validity -> {

            query.addCriteria(Criteria.where("startDate").lte(validity.toLocalDateTime()).and("expirationDate").gte(validity.toLocalDateTime()));
        });

        return query;
    }

}
