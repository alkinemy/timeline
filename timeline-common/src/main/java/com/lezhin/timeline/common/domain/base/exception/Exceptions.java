package com.lezhin.timeline.common.domain.base.exception;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.Objects;

@Slf4j
public abstract class Exceptions {
	
	private static final String DEFAULT_ERROR_CODE = "INTERNAL";
	private static final String DEFAULT_ERROR_MSG = "에러가 발생하였습니다";

	public static void throwsException(boolean condition, ErrorCode errorCode, Object... args) {
		Objects.requireNonNull(errorCode);

		if (condition) {
			throw newException(errorCode, args);
		}
	}

	public static MessageException newException(ErrorCode errorCode, Throwable t, Object... args) {
		try {
			return newExceptionInstance(errorCode, t, args);
		} catch (Exception e) {
			log.error("Exception create failed.", e);
			return new MessageException(DEFAULT_ERROR_MSG, t, DEFAULT_ERROR_CODE, null);
		}
	}

	protected static MessageException newExceptionInstance(ErrorCode errorCode, Throwable t, Object... args)
		throws NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
		Class<? extends MessageException> exceptionClass = errorCode.getExceptionClass();
		Constructor<? extends MessageException> constructor = exceptionClass.getConstructor(String.class, Throwable.class, String.class,
			Object[].class);
		return constructor.newInstance(errorCode.getDefaultMessage(), t, errorCode.name(), args);
	}

	public static MessageException newException(ErrorCode errorCode, Object... args) {
		try {
			return newExceptionInstance(errorCode, args);
		} catch (Exception e) {
			log.error("Exception create failed.", e);
			return new MessageException(DEFAULT_ERROR_MSG, DEFAULT_ERROR_CODE, null);
		}
	}

	protected static MessageException newExceptionInstance(ErrorCode errorCode, Object... args)
		throws NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
		Class<? extends MessageException> exceptionClass = errorCode.getExceptionClass();
		Constructor<? extends MessageException> constructor = exceptionClass.getConstructor(String.class, String.class, Object[].class);
		return constructor.newInstance(errorCode.getDefaultMessage(), errorCode.name(), args);
	}

}
