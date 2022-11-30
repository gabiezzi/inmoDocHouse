package com.egg.inmoDocHouse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;


}
