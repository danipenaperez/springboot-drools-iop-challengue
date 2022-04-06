package com.dppware.swa.domain.entity;

import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * Price Domain Object
 * 
 * @author dpena
 *
 */
@Data
@Builder
public class PriceDomainEntity {
	private Long brandId;
	private Long productId;
	private Long rateId;
	private OffsetDateTime startDateRate;
	private OffsetDateTime endDateRate;
	private Long priority;
	private Double price;
	private String currency;
}
