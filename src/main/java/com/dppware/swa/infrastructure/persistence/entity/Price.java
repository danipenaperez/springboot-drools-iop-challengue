package com.dppware.swa.infrastructure.persistence.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.dppware.swa.infrastructure.persistence.entity.auditable.Auditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class Price extends Auditable implements Serializable{

	@EmbeddedId
	PriceId priceId;
	
	
	@Column(name = "startDateRate")
	private OffsetDateTime startDateRate;
	@Column(name = "endDateRate")
	private OffsetDateTime endDateRate;
	
	@Column
    private Long priority;
    
	@Column
    private Double price;
    
	@Column
    private String currency;
}
