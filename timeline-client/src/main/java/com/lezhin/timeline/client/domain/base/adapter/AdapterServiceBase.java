package com.lezhin.timeline.client.domain.base.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

public abstract class AdapterServiceBase {

	@Autowired
	private RetryTemplate timelineRetryTemplate;

	protected <T, E extends Throwable> T doWithRetry(RetryCallback<T, E> retryCallback) throws E {
		return timelineRetryTemplate.execute(retryCallback);
	}

	protected abstract String getBaseUrl();

	protected abstract RestTemplate getRestTemplate();

}
