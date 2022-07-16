package com.juliomoraes.dsmeta.service.exceptions;

public class SaleExceptionNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SaleExceptionNotFound(final String message) {
		super(message);
	}
}
