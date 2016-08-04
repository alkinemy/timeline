package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserFollowForm;
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
public class TimelineFollowAdapterService {

	@Autowired
	private RestTemplate timelineRestTemplate;

	@Autowired
	private RetryTemplate timelineRetryTemplate;

	@Autowired
	private TimelineServerRestProperties timelineServerRestProperties;

	public void addFollowing(TimelineUserFollowForm followForm) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/follows/follow").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, followForm, Void.class));
	}

	public void removeFollowing(TimelineUserFollowForm followForm) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/follows/unfollow").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, followForm, Void.class));
	}

	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/follows/followings?loginId={loginId}&name={name}").toString();
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", user.getLoginId());
		params.put("name", user.getLoginId());
		ParameterizedTypeReference<List<TimelineUserDto>> typeReference = new ParameterizedTypeReference<List<TimelineUserDto>>() { };
		return timelineRetryTemplate.execute(context -> timelineRestTemplate.exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public List<TimelineUserDto> getFollowers(TimelineUserDto user) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/follows/followers?loginId={loginId}&name={name}").toString();
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", user.getLoginId());
		params.put("name", user.getLoginId());
		ParameterizedTypeReference<List<TimelineUserDto>> typeReference = new ParameterizedTypeReference<List<TimelineUserDto>>() { };
		return timelineRetryTemplate.execute(context -> timelineRestTemplate.exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

}
