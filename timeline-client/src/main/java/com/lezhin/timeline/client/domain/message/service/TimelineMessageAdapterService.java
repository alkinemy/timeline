package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TimelineMessageAdapterService {

	@Autowired
	private RestTemplate timelineRestTemplate;
	@Autowired
	private RetryTemplate timelineRetryTemplate;

	@Autowired
	private TimelineServerRestProperties timelineServerRestProperties;

	public void postMessage(TimelineMessagePostForm postForm) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/messages").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, postForm, Void.class));
	}

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessageParam userMessageParam) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/newsfeed")
			.append(buildUserMessageQueryString(userMessageParam))
			.toString();
		return getMessages(url, userMessageParam);
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessageParam userMessageParam) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/messages")
			.append(buildUserMessageQueryString(userMessageParam))
			.toString();
		return getMessages(url, userMessageParam);
	}

	private String buildUserMessageQueryString(TimelineUserMessageParam userMessageParam) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("?loginId={loginId}");
		if (userMessageParam.getSize() != null) {
			queryString.append("?size={size}");
		}
		if (StringUtils.isNotBlank(userMessageParam.getLastTimelineMessageId())) {
			queryString.append("?lastTimelineMessageId={lastTimelineMessageId}");
		}
		return queryString.toString();
	}

	private List<TimelineMessageDto> getMessages(String url, TimelineUserMessageParam userMessageParam) {
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", userMessageParam.getLoginId());
		params.put("size", userMessageParam.getSize());
		params.put("lastTimelineMessageId", userMessageParam.getLastTimelineMessageId());

		ParameterizedTypeReference<List<TimelineMessageDto>> typeReference = new ParameterizedTypeReference<List<TimelineMessageDto>>() { };
		return timelineRetryTemplate.execute(context -> timelineRestTemplate.exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

}
