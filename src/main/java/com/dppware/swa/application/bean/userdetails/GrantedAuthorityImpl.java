package com.dppware.swa.application.bean.userdetails;

import org.springframework.security.core.GrantedAuthority;


public class GrantedAuthorityImpl implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985664647306680955L;
	
	private String authorityName;
	
	public GrantedAuthorityImpl(String authorityName ) {
		super();
		this.authorityName=authorityName;
	}
	@Override
	public String getAuthority() {
		return this.authorityName;
	}

}
