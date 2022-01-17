package com.edn.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface DocumentKeyRepository extends PagingAndSortingRepository<DocumentKey, Long>, JpaRepository<DocumentKey, Long> {
    static final String SQL_DOCS_ALL  = "SELECT dk.* FROM document_key dk";
    static final String SQL_DOCS_BY_KEY  = "SELECT dk.* FROM document_key dk WHERE dk.key_value = :key";
    static final String SQL_DOCS_BY_COMPANY  = "SELECT dk.* FROM document_key dk WHERE dk.company_id = :companyId";
    static final String SQL_DOCS_BY_COMPANY_AND_KEY  = "SELECT dk.* FROM document_key dk WHERE dk.company_id = :companyId AND dk.key_value = :key";

    List<DocumentKey> findAllByCompanyIdAndKeyValueIn(int companyId, List<BigInteger> keys);

    @Query(value = SQL_DOCS_ALL, nativeQuery = true)
    Page<DocumentKey> findAllDocumentKeys(Pageable pageable);

    @Query(value = SQL_DOCS_BY_KEY, nativeQuery = true)
    Page<DocumentKey> findDocumentKeysByKey(@Param("key") BigInteger key, Pageable pageable);

    @Query(value = SQL_DOCS_BY_COMPANY, nativeQuery = true)
    Page<DocumentKey> findDocumentKeysByCompanyId(@Param("companyId") int companyId, Pageable pageable);

    @Query(value = SQL_DOCS_BY_COMPANY_AND_KEY, nativeQuery = true)
    Page<DocumentKey> findDocumentKeysByCompanyIdAndKey(@Param("companyId") int companyId, @Param("key") BigInteger key, Pageable pageable);

}
