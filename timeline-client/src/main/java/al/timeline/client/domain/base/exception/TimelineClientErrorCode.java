package al.timeline.client.domain.base.exception;

import al.timeline.common.domain.base.exception.ErrorCode;
import al.timeline.common.domain.base.exception.MessageException;
import lombok.Getter;

@Getter
public enum TimelineClientErrorCode implements ErrorCode {

	INTERNAL("Internal error"),
	BUILD_URL_FAILURE("Fail to build request url")
	;

	private String defaultMessage;
	private Class<? extends MessageException> exceptionClass;

	TimelineClientErrorCode(String defaultMessage) {
		this(defaultMessage, MessageException.class);
	}

	TimelineClientErrorCode(String defaultMessage, Class<? extends MessageException> exceptionClass) {
		this.defaultMessage = defaultMessage;
		this.exceptionClass = exceptionClass;
	}

}
