package com.edn.base;

import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DocumentKeyRequestTO {

    private BigInteger keyValue;

}
