package com.dppware.swa.infrastructure.persistence.config;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.dppware.swa.infrastructure.persistence.config.audit.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider", dateTimeProviderRef = "dateTimeProvider")
public class PersistenceAuditingConfig {
	/**
	 * Inject AuditiorAwareImpl
	 * 
	 * @return
	 */
	@Bean
	AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}
	/**
	 * Register conversor to use a OffsetDateTime instances (OffsetDateTime is no supported by default)
	 * @return
	 */
	@Bean
	public DateTimeProvider dateTimeProvider() {
		return () -> Optional.of(ZonedDateTime.now());
	}
}
