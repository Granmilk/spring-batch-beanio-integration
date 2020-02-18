package com.demo.project.core.repository;

import com.demo.project.core.domain.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {

}