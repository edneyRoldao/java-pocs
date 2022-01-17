package com.edn.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentKeyServiceImpl implements DocumentKeyService {

    @Value("${document.format.length}")
    private String documentKeySize;

    private final DocumentKeyRepository repository;

    @Override
    public void saveAllDocumentKeys(List<DocumentKey> documentKeys) {
        log.info("## DocumentKeyServiceImpl.saveAllDocumentKeys ##");
        repository.saveAll(documentKeys);
    }

    @Override
    public List<DocumentKeyResponseTO> validateKeys(int companyId, List<DocumentKeyRequestTO> keys) {
        log.info("## DocumentKeyServiceImpl.validateKeys ##");

        List<BigInteger> keysRequest = keys
                .stream()
                .map(DocumentKeyRequestTO::getKeyValue)
                .collect(Collectors.toList());

        List<DocumentKey> keysFound = repository.findAllByCompanyIdAndKeyValueIn(companyId, keysRequest);
        keysFound.forEach(k -> k.setStatus(DocumentKeyStatus.VALIDATED));
        saveAllDocumentKeys(keysFound);

        return keysValidationBuilder(keysRequest, keysFound);
    }

    @Override
    public Page<DocumentKey> getPagedKeys(int companyId, BigInteger key, int pageSize, int pageNumber) {
        log.info("## DocumentKeyServiceImpl.getPagedKeys ##");
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("id").ascending());

        if (companyId != 0 && Objects.nonNull(key))
            return repository.findDocumentKeysByCompanyIdAndKey(companyId, key, pageRequest);

        if (companyId != 0)
            return repository.findDocumentKeysByCompanyId(companyId, pageRequest);

        if (Objects.nonNull(key))
            return repository.findDocumentKeysByKey(key, pageRequest);

        return repository.findAllDocumentKeys(pageRequest);
    }

    private List<DocumentKeyResponseTO> keysValidationBuilder(List<BigInteger> keysRequest,
            List<DocumentKey> validKeys) {

        List<DocumentKeyResponseTO> keysResponse = new ArrayList<>();

        keysRequest.forEach(k -> {
            DocumentKeyResponseTO keyResponse = new DocumentKeyResponseTO(k);

            if (validKeys.stream().anyMatch(dk -> dk.getKeyValue().equals(k))) {
                keyResponse.setStatus(DocumentKeyStatus.VALIDATED);
            } else {
                keyResponse.setStatus(DocumentKeyStatus.INVALID);
                String errorMessage = getErrorMessageFromKey(k);
                keyResponse.setErrorValidationMessage(errorMessage);
            }

            keysResponse.add(keyResponse);
        });

        return keysResponse;
    }

    private String getErrorMessageFromKey(BigInteger key) {
        if (Objects.isNull(key) || key.toString().length() == 0)
            return "key null or empty";

        int keySize = key.toString().length();
        int documentKeySize = Integer.parseInt(this.documentKeySize);

        if (keySize > documentKeySize)
            return "key format invalid";

        if (keySize < documentKeySize)
            return "key incomplete";

        return "key does not exist";
    }

}
