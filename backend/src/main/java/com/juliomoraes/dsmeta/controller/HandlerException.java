package com.juliomoraes.dsmeta.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.juliomoraes.dsmeta.service.exceptions.SaleExceptionNotFound;

@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler(SaleExceptionNotFound.class)
	private ResponseEntity<ErrorExceptionHandler> handlerStandardException(SaleExceptionNotFound s, HttpServletRequest r) {
		ErrorExceptionHandler exception = new ErrorExceptionHandler();
		exception.setTimestamp(LocalDate.now());
		exception.setStatus(HttpStatus.SC_NOT_FOUND);
		exception.setError(s.getMessage());
		exception.setPath(r.getRequestURI());
		
		return ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body(exception);
	}
}
