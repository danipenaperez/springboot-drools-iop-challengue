package com.dppware.swa.infrastructure.persistence.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PriceId implements Serializable{
	
    private Long brandId;

    private Long productId;
    
    private Long rateId;
}
