package com.edntisolutions.aouth.api.repository;

import com.edntisolutions.aouth.api.model.Ecommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceRepository extends JpaRepository<Ecommerce, Long> {
}
