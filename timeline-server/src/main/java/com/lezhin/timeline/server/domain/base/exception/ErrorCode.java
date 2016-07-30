package com.lezhin.timeline.server.domain.base.exception;

public interface ErrorCode {

	String name();

	Class<? extends MessageException> getExceptionClass();

	String getDefaultMessage();

}
