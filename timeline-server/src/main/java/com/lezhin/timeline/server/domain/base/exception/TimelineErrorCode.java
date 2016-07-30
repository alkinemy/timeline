package com.lezhin.timeline.server.domain.base.exception;

import lombok.Getter;

@Getter
public enum TimelineErrorCode implements ErrorCode {
	INTERNAL("Internal error"),
	ENTITY_NOT_FOUND("Entity is not found", EntityNotFoundException.class),
	;

	private String defaultMessage;
	private Class<? extends MessageException> exceptionClass;

	TimelineErrorCode(String defaultMessage) {
		this(defaultMessage, MessageException.class);
	}

	TimelineErrorCode(String defaultMessage, Class<? extends MessageException> exceptionClass) {
		this.defaultMessage = defaultMessage;
		this.exceptionClass = exceptionClass;
	}
}
