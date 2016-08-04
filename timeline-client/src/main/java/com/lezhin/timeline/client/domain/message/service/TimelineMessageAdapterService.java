package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.domain.base.adapter.TimelineServerAdapterBase;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageParam;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessagesParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TimelineMessageAdapterService extends TimelineServerAdapterBase {

	public void postMessage(TimelineMessagePostForm postForm) {
		String url = new StringBuilder().append(getBaseUrl()).append("/messages").toString();
		doWithRetry(context -> getRestTemplate().postForObject(url, postForm, Void.class));
	}

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessagesParam userMessageParam) {
		String url = new StringBuilder().append(getBaseUrl()).append("/newsfeed")
			.append(buildUserMessageQueryString(userMessageParam))
			.toString();
		return getMessages(url, userMessageParam);
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessagesParam userMessageParam) {
		String url = new StringBuilder().append(getBaseUrl()).append("/messages")
			.append(buildUserMessageQueryString(userMessageParam))
			.toString();
		return getMessages(url, userMessageParam);
	}

	private String buildUserMessageQueryString(TimelineUserMessagesParam userMessageParam) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("?loginId={loginId}");
		if (userMessageParam.getSize() != null) {
			queryString.append("&size={size}");
		}
		if (StringUtils.isNotBlank(userMessageParam.getLastTimelineMessageId())) {
			queryString.append("&lastTimelineMessageId={lastTimelineMessageId}");
		}
		return queryString.toString();
	}

	private List<TimelineMessageDto> getMessages(String url, TimelineUserMessagesParam userMessageParam) {
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", userMessageParam.getLoginId());
		params.put("size", userMessageParam.getSize());
		params.put("lastTimelineMessageId", userMessageParam.getLastTimelineMessageId());

		ParameterizedTypeReference<List<TimelineMessageDto>> typeReference = new ParameterizedTypeReference<List<TimelineMessageDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public TimelineMessageDto getMessage(TimelineUserMessageParam userMessageParam) {
		String url = new StringBuilder().append(getBaseUrl()).append("/{loginId}/messages/{messageId}")
			.toString();
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", userMessageParam.getLoginId());
		params.put("messageId", userMessageParam.getMessageId());
		return doWithRetry(context -> getRestTemplate().getForObject(url, TimelineMessageDto.class, params));
	}
}
