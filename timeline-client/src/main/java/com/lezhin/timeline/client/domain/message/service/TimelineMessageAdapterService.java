package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.domain.base.rest.TimelineServerAdapterBase;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageConditions;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessagesConditions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TimelineMessageAdapterService extends TimelineServerAdapterBase {

	public void postMessage(TimelineMessagePostForm postForm) {
		String url = buildUrl("/messages");
		doWithRetry(context -> getRestTemplate().postForObject(url, postForm, Void.class));
	}

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessagesConditions userMessageParam) {
		String url = buildUrl("/newsfeed", userMessageParam);
		Map<String, Object> params = buildParameters(userMessageParam);
		ParameterizedTypeReference<List<TimelineMessageDto>> typeReference = new ParameterizedTypeReference<List<TimelineMessageDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessagesConditions userMessageParam) {
		String url = buildUrl("/messages", userMessageParam);
		Map<String, Object> params = buildParameters(userMessageParam);
		ParameterizedTypeReference<List<TimelineMessageDto>> typeReference = new ParameterizedTypeReference<List<TimelineMessageDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public TimelineMessageDto getMessage(TimelineUserMessageConditions userMessageParam) {
		String url = buildUrl("/{loginId}/messages/{messageId}");
		Map<String, Object> params = buildParameters(userMessageParam);
		return doWithRetry(context -> getRestTemplate().getForObject(url, TimelineMessageDto.class, params));
	}
}
