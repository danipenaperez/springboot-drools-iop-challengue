package com.dppware.swa.infrastructure.persistence.entity.auditable;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter(AccessLevel.PUBLIC)
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable
{
    @CreatedBy
    @Column(name = "createdBy")
    private String createdBy = "antonio";
  
    @CreatedDate
    @Column(name = "createdDate")
    private OffsetDateTime createdDate = OffsetDateTime.now();
  
    @LastModifiedBy
    @Column(name = "lastUpdatedBy")
    private String lastUpdatedBy = "luis";
  
    @LastModifiedDate
    @Column(name = "lastupdatedDate")
    private OffsetDateTime lastupdatedDate = OffsetDateTime.now();
}
