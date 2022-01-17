package com.edn.base;

import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DocumentKeyResponseTO {

    private BigInteger keyValue;
    private DocumentKeyStatus status;
    private String errorValidationMessage;

    public DocumentKeyResponseTO(BigInteger keyValue) {
        this.keyValue = keyValue;
    }

}
