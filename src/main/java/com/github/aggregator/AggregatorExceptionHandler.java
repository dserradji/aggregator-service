package com.github.aggregator;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AggregatorExceptionHandler {

	@ExceptionHandler(Exception.class)
	ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<>("Ooops! " + ex.getMessage(), INTERNAL_SERVER_ERROR);
	}

}
