package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineNewsFeedParam;
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

	public List<TimelineMessageDto> getNewsFeed(TimelineNewsFeedParam newsFeedParam) {
		String url = buildNewsFeedUrl(newsFeedParam);
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", newsFeedParam.getLoginId());
		params.put("size", newsFeedParam.getSize());
		params.put("lastTimelineMessageId", newsFeedParam.getLastTimelineMessageId());

		ParameterizedTypeReference<List<TimelineMessageDto>> typeReference = new ParameterizedTypeReference<List<TimelineMessageDto>>() { };
		return timelineRetryTemplate.execute(context -> timelineRestTemplate.exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	private String buildNewsFeedUrl(TimelineNewsFeedParam newsFeedParam) {
		StringBuilder url = new StringBuilder()
			.append(timelineServerRestProperties.getBaseUrl()).append("/newsfeed")
			.append("?loginId={loginId}");
		if (newsFeedParam.getSize() != null) {
			url.append("?size={size}");
		}
		if (StringUtils.isNotBlank(newsFeedParam.getLastTimelineMessageId())) {
			url.append("?lastTimelineMessageId={lastTimelineMessageId}");
		}
		return url.toString();
	}
}
