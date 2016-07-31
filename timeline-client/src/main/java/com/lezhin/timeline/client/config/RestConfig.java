package com.lezhin.timeline.client.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

@EnableRetry
@Configuration
@EnableConfigurationProperties({ RestProperties.class, TimelineServerRestProperties.class, TimelineMemberRestProperties.class })
public class RestConfig {

	@Bean
	public RestTemplate timelineRestTemplate(RestProperties restProperties) {
		return new RestTemplate(clientHttpRequestFactory(restProperties));
	}

	private ClientHttpRequestFactory clientHttpRequestFactory(RestProperties restProperties) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(restProperties.getConnectTimeout());
		clientHttpRequestFactory.setConnectionRequestTimeout(restProperties.getConnectionRequestTimeout());
		clientHttpRequestFactory.setReadTimeout(restProperties.getReadTimeout());
		return clientHttpRequestFactory;
	}

	@Bean
	public RetryTemplate timelineRetryTemplate(RestProperties restProperties) {
		SimpleRetryPolicy policy = new SimpleRetryPolicy();
		policy.setMaxAttempts(restProperties.getMaxAttempts());

		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
		backOffPolicy.setInitialInterval(restProperties.getInitialInterval());
		backOffPolicy.setMaxInterval(restProperties.getMaxInterval());
		RetryTemplate retryTemplate = new RetryTemplate();
		retryTemplate.setRetryPolicy(policy);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		return retryTemplate;
	}

}
