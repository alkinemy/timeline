package al.timeline.client.config;

import al.timeline.client.web.base.interceptor.BasicAuthInterceptor;
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
@EnableConfigurationProperties({ RestRetryProperties.class, TimelineServerRestProperties.class, TimelineUserRestProperties.class })
public class RestConfig {

	@Bean
	public RestTemplate timelineServerRestTemplate(TimelineServerRestProperties properties) {
		RestTemplate restTemplate = new RestTemplate(
			clientHttpRequestFactory(properties.getConnectTimeout(), properties.getConnectionRequestTimeout(), properties.getReadTimeout()));
		restTemplate.getInterceptors().add(new BasicAuthInterceptor(properties.getUsername(), properties.getPassword()));
		return restTemplate;
	}

	@Bean
	public RestTemplate timelineMemberRestTemplate(TimelineUserRestProperties properties) {
		RestTemplate restTemplate = new RestTemplate(
			clientHttpRequestFactory(properties.getConnectTimeout(), properties.getConnectionRequestTimeout(), properties.getReadTimeout()));
		restTemplate.getInterceptors().add(new BasicAuthInterceptor(properties.getUsername(), properties.getPassword()));
		return restTemplate;
	}

	private ClientHttpRequestFactory clientHttpRequestFactory(int connectionTimeout, int connectionRequestTimeout, int readTimeout) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(connectionTimeout);
		clientHttpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
		clientHttpRequestFactory.setReadTimeout(readTimeout);
		return clientHttpRequestFactory;
	}

	@Bean
	public RetryTemplate timelineRetryTemplate(RestRetryProperties restRetryProperties) {
		SimpleRetryPolicy policy = new SimpleRetryPolicy();
		policy.setMaxAttempts(restRetryProperties.getMaxAttempts());

		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
		backOffPolicy.setInitialInterval(restRetryProperties.getInitialInterval());
		backOffPolicy.setMaxInterval(restRetryProperties.getMaxInterval());
		RetryTemplate retryTemplate = new RetryTemplate();
		retryTemplate.setRetryPolicy(policy);
		retryTemplate.setBackOffPolicy(backOffPolicy);
		return retryTemplate;
	}

}
