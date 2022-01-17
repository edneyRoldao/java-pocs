package com.edn.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "discounts")
public class DiscountDocument {

    @Id
    private String id;
    private String reason;
    private Boolean enabled;
    private LocalDateTime startDate;
    private ObjectId serviceContractId;
    private LocalDateTime expirationDate;

}
