package com.dppware.swa.infrastructure.controllers.transformer.impl;

import org.springframework.stereotype.Component;

import com.dppware.swa.api.model.AuthResponse;
import com.dppware.swa.application.bean.SuccessAuthOBean;
import com.dppware.swa.infrastructure.controllers.transformer.AuthDTOTransformer;
import com.dppware.swa.infrastructure.controllers.transformer.mapper.AuthDTOMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthDTOTransformerImpl implements AuthDTOTransformer{

	AuthDTOMapper authDTOMapper;
	
	public AuthResponse from(SuccessAuthOBean successAuthOBean) {
		return authDTOMapper.from(successAuthOBean);
	}
}
