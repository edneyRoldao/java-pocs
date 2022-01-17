package com.edn.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("all")
@Entity
@Table(name = "document_key")
public class DocumentKey {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 6, nullable = false)
    private int companyId;

    @Column(length = 44, nullable = false)
    private BigInteger keyValue;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 10, nullable = false)
    private DocumentKeyStatus status;

}
