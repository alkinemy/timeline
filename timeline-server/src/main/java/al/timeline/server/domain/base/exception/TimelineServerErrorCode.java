package al.timeline.server.domain.base.exception;

import al.timeline.common.domain.base.exception.EntityNotFoundException;
import al.timeline.common.domain.base.exception.ErrorCode;
import al.timeline.common.domain.base.exception.MessageException;
import lombok.Getter;

@Getter
public enum TimelineServerErrorCode implements ErrorCode {

	INTERNAL("Internal error"),
	ENTITY_NOT_FOUND("Entity is not found", EntityNotFoundException.class),
	;

	private String defaultMessage;
	private Class<? extends MessageException> exceptionClass;

	TimelineServerErrorCode(String defaultMessage) {
		this(defaultMessage, MessageException.class);
	}

	TimelineServerErrorCode(String defaultMessage, Class<? extends MessageException> exceptionClass) {
		this.defaultMessage = defaultMessage;
		this.exceptionClass = exceptionClass;
	}

}
