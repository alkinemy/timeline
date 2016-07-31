package com.lezhin.timeline.common.domain.base.exception;

public interface ErrorCode {

	String name();

	Class<? extends MessageException> getExceptionClass();

	String getDefaultMessage();

}
