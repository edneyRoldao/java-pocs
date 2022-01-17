package com.edn.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DocumentKeyController implements DocumentKeyApi {

    private final DocumentKeyService service;

    @Override
    public ResponseEntity<List<DocumentKeyResponseTO>> validateKeys(
            int companyId,
            List<DocumentKeyRequestTO> docs) {

        validateKeysRequestValidator(companyId, docs);
        List<DocumentKeyResponseTO> keysValidated = service.validateKeys(companyId, docs);

        return ResponseEntity.status(HttpStatus.OK).body(keysValidated);
    }

    @Override
    public ResponseEntity<Page<DocumentKey>> listKeys(
            int companyId,
            BigInteger documentKey,
            int pageSize,
            int pageNumber) {

        listKeysRequestValidator(pageSize);
        Page<DocumentKey> keysList = service.getPagedKeys(companyId, documentKey, pageSize, pageNumber);

        return ResponseEntity.status(HttpStatus.OK).body(keysList);
    }

    private void validateKeysRequestValidator(int companyId, List<DocumentKeyRequestTO> docs) {
        if (companyId <= 0) {
            throw new BadRequestException("company id must be provided");
        }

        if (Objects.isNull(docs) || docs.isEmpty()) {
            throw new BadRequestException("at least one document key must be provided");
        }

        if (docs.size() > 20) {
            throw new BadRequestException("The maxlength of documents key is 20 by request");
        }
    }

    private void listKeysRequestValidator(int pageSize) {
        if (pageSize == 0) {
            throw new BadRequestException("Query param pageSize must be greater than zero");
        }

        if (pageSize > 20) {
            throw new BadRequestException("The max pageSize is 20");
        }
    }

}
