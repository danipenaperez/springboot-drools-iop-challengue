package com.dppware.swa.domain.entity;

import java.util.List;

import com.dppware.swa.infrastructure.persistence.entity.Price;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceCalculatorOperation {

	List<PriceDomainEntity> input;
	PriceDomainEntity output;
}
