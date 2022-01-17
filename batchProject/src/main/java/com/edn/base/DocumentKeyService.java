package com.edn.base;

import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.util.List;

public interface DocumentKeyService {

    void saveAllDocumentKeys(List<DocumentKey> documentKeys);

    List<DocumentKeyResponseTO> validateKeys(int companyId, List<DocumentKeyRequestTO> keys);

    Page<DocumentKey> getPagedKeys(int companyId, BigInteger key, int pageSize, int pageNumber);

}
