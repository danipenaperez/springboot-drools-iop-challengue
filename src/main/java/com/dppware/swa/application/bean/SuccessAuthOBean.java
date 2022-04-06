package com.dppware.swa.application.bean;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class SuccessAuthOBean {
	  
	  private Long userId;
	  private String userName;
	  private String token;
}
