package kr.or.ddit.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@RequestMapping("/exception")
	public String exception() {
		throw new ArithmeticException();
	}

}
