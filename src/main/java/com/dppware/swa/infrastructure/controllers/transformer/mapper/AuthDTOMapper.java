package com.dppware.swa.infrastructure.controllers.transformer.mapper;

import org.mapstruct.Mapper;

import com.dppware.swa.api.model.AuthResponse;
import com.dppware.swa.application.bean.SuccessAuthOBean;

@Mapper(componentModel = "spring")
public interface AuthDTOMapper {

	AuthResponse from(SuccessAuthOBean successAuthOBean);
}
