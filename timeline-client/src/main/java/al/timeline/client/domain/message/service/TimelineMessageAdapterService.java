package al.timeline.client.domain.message.service;

import al.timeline.client.domain.base.rest.TimelineServerAdapterBase;
import al.timeline.client.domain.message.dto.TimelineMessageDto;
import al.timeline.client.domain.message.dto.TimelineMessagePostForm;
import al.timeline.client.domain.message.dto.TimelineUserMessageSearchConditions;
import al.timeline.client.domain.message.dto.TimelineUserMessagesSearchConditions;
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

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessagesSearchConditions userMessageConditions) {
		String url = buildUrl("/newsfeed", userMessageConditions);
		Map<String, Object> params = buildParameters(userMessageConditions);
		ParameterizedTypeReference<List<TimelineMessageDto>> typeReference = new ParameterizedTypeReference<List<TimelineMessageDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessagesSearchConditions userMessageConditions) {
		String url = buildUrl("/messages", userMessageConditions);
		Map<String, Object> params = buildParameters(userMessageConditions);
		ParameterizedTypeReference<List<TimelineMessageDto>> typeReference = new ParameterizedTypeReference<List<TimelineMessageDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public TimelineMessageDto getMessage(TimelineUserMessageSearchConditions userMessageConditions) {
		String url = buildUrl("/{loginId}/messages/{messageId}");
		Map<String, Object> params = buildParameters(userMessageConditions);
		return doWithRetry(context -> getRestTemplate().getForObject(url, TimelineMessageDto.class, params));
	}
}
