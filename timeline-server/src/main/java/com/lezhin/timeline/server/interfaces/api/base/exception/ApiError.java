package com.lezhin.timeline.server.interfaces.api.base.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {

	private String code;
	private String message;
	private String stacktrace;

}
