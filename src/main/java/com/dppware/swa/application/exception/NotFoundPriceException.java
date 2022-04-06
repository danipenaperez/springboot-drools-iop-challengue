package com.dppware.swa.application.exception;

public class NotFoundPriceException extends RuntimeException {

	public NotFoundPriceException() {
		super("Not found price for input requested Data");
	}
}
