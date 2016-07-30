package com.lezhin.timeline.server.domain.base.exception;

public class EntityNotFoundException extends MessageException {

	private static final String DEFAULT_MESSAGE = TimelineErrorCode.ENTITY_NOT_FOUND.getDefaultMessage();
	private static final String DEFAULT_CODE = TimelineErrorCode.ENTITY_NOT_FOUND.name();

	public EntityNotFoundException() {
		super(DEFAULT_MESSAGE, DEFAULT_CODE, null);
	}

	public EntityNotFoundException(String defaultMessage, String code, Object[] args) {
		super(defaultMessage, code, args);
	}

	public EntityNotFoundException(String defaultMessage, Throwable cause, String code, Object[] args) {
		super(defaultMessage, cause, code, args);
	}

}
