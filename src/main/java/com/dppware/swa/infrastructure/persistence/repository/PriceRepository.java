package com.dppware.swa.infrastructure.persistence.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dppware.swa.infrastructure.persistence.entity.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

	@Query("select a from Price a where a.priceId.brandId = :brandId and a.priceId.productId = :productId and  a.startDateRate <= :searchDate and a.endDateRate >= :searchDate")
	List<Price> findActive(@Param("brandId") long brandId, @Param("productId") long productId, @Param("searchDate") OffsetDateTime searchDate);
	
}