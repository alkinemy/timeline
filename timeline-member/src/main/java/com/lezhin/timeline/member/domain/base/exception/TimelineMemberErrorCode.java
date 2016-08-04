package com.lezhin.timeline.member.domain.base.exception;

import com.lezhin.timeline.common.domain.base.exception.EntityNotFoundException;
import com.lezhin.timeline.common.domain.base.exception.ErrorCode;
import com.lezhin.timeline.common.domain.base.exception.MessageException;
import lombok.Getter;

@Getter
public enum TimelineMemberErrorCode implements ErrorCode {

	INTERNAL("Internal error"),
	ENTITY_NOT_FOUND("Entity is not found", EntityNotFoundException.class),
	;

	private String defaultMessage;
	private Class<? extends MessageException> exceptionClass;

	TimelineMemberErrorCode(String defaultMessage) {
		this(defaultMessage, MessageException.class);
	}

	TimelineMemberErrorCode(String defaultMessage, Class<? extends MessageException> exceptionClass) {
		this.defaultMessage = defaultMessage;
		this.exceptionClass = exceptionClass;
	}

}
