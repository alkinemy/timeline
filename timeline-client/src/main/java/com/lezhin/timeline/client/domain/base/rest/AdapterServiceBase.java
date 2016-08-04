package com.lezhin.timeline.client.domain.base.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
public abstract class AdapterServiceBase {

	@Autowired
	private RetryTemplate timelineRetryTemplate;

	protected <T> String buildUrl(String path) {
		return new StringBuilder().append(getBaseUrl()).append(path).toString();
	}

	protected <T> String buildUrl(String path, T t) {
		return RestRequestBuildUtils.buildUrl(getBaseUrl(), path, t);
	}

	protected <T> Map<String, Object> buildParameters(T t) {
		return RestRequestBuildUtils.buildParameters(t);
	}

	protected <T, E extends Throwable> T doWithRetry(RetryCallback<T, E> retryCallback) throws E {
		return timelineRetryTemplate.execute(retryCallback);
	}

	protected abstract String getBaseUrl();

	protected abstract RestTemplate getRestTemplate();

}
