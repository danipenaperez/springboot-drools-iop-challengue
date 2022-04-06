package com.dppware.swa.infrastructure.controllers.transformer;

import com.dppware.swa.api.model.AuthResponse;
import com.dppware.swa.application.bean.SuccessAuthOBean;

public interface AuthDTOTransformer {

	public AuthResponse from(SuccessAuthOBean successAuthOBean);
}
