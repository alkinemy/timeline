package com.lezhin.timeline.server.interfaces.api.base.exception;

import com.lezhin.timeline.server.domain.base.exception.MessageException;
import com.lezhin.timeline.server.domain.base.exception.TimelineErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@ControllerAdvice(annotations = { RestController.class})
public class ApiExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleException(Exception ex) {
		log.warn("handleException", ex);
		ApiError error = new ApiError();
		error.setCode(TimelineErrorCode.INTERNAL.name());
		error.setMessage(TimelineErrorCode.INTERNAL.getDefaultMessage());
		return error;
	}

	@ExceptionHandler(MessageException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleException(MessageException ex) {
		log.warn("handleMessageException", ex);
		ApiError error = new ApiError();
		error.setCode(ex.getCode());
		error.setMessage(ex.getMessage());
		return error;
	}

}
