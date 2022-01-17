package com.edn.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountFilterDTO {
    private int page = 0;
    private int size = 50;
    private String serviceContractId;
    private List<String> serviceContractIds;
    private Boolean enabled;
//    private LocalDateTime validity;
    private OffsetDateTime validity;
    private OperatorUnitEnum unit;
    private List<OperatorUnitEnum> units;
}
