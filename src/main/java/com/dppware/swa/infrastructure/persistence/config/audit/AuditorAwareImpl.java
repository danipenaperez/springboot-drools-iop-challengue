package com.dppware.swa.infrastructure.persistence.config.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * Default FWKCNA Auditor
 * @author dpena
 *
 */
public class AuditorAwareImpl implements AuditorAware<String> {
 
	/**
	 * Default values for cod_v_usuario_creacion/ cod_v_usuario_modificacion
	 */
	public static final String DEFAULT_AUDITER_USER = "NotUserOnSecurityContext";
	
	/**
	 * If exist a security context return the Principal username. If not, returns DEFAULT_AUDITER_USER.
	 * @see  AuditorAware.java
	 */
	public Optional<String> getCurrentAuditor() {
		
		String currentAud = DEFAULT_AUDITER_USER;

		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication !=null ) {
			currentAud = authentication.getName();
		}
		
	    return Optional.of(currentAud);
	}
}