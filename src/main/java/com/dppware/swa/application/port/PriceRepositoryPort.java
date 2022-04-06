package com.dppware.swa.application.port;

import java.time.OffsetDateTime;
import java.util.List;

import com.dppware.swa.domain.entity.PriceDomainEntity;

public interface PriceRepositoryPort {
	List<PriceDomainEntity> findActive( Long brandId, Long productId, OffsetDateTime searchDate);
}
