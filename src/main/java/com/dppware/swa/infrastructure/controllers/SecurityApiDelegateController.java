package com.dppware.swa.infrastructure.controllers;

import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.dppware.swa.api.SecurityApiDelegate;
import com.dppware.swa.api.model.AuthResponse;
import com.dppware.swa.application.AuthenticationService;
import com.dppware.swa.application.bean.SuccessAuthOBean;
import com.dppware.swa.infrastructure.controllers.transformer.AuthDTOTransformer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class SecurityApiDelegateController implements SecurityApiDelegate{
	
	private AuthenticationService authenticationService;
	
	AuthDTOTransformer authDTOTransformer;
	
	public ResponseEntity<AuthResponse> login(String authorization) {
		String formattedValue = authorization.replace("Basic ", "");
		byte[] decodedBytes = Base64.getDecoder().decode(formattedValue);
		String decodedString = new String(decodedBytes);
		String userName= decodedString.split(":")[0];
		String password= decodedString.split(":")[1];
		
		SuccessAuthOBean successAuthOBean = authenticationService.login(userName, password); 
		
        return new ResponseEntity<>(authDTOTransformer.from(successAuthOBean), HttpStatus.CREATED);
	}
	
	
	
}
