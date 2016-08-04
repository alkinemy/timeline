package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.base.rest.TimelineServerAdapterBase;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserFollowForm;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TimelineFollowAdapterService extends TimelineServerAdapterBase {

	public void follow(TimelineUserFollowForm followForm) {
		String url = buildUrl("/follows/follow");
		doWithRetry(context -> getRestTemplate().postForObject(url, followForm, Void.class));
	}

	public void unfollow(TimelineUserFollowForm followForm) {
		String url = buildUrl("/follows/unfollow");
		doWithRetry(context -> getRestTemplate().postForObject(url, followForm, Void.class));
	}

	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		String url = buildUrl("/follows/followings", user);
		Map<String, Object> params = buildParameters(user);
		ParameterizedTypeReference<List<TimelineUserDto>> typeReference = new ParameterizedTypeReference<List<TimelineUserDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public List<TimelineUserDto> getFollowers(TimelineUserDto user) {
		String url = buildUrl("/follows/followers", user);
		Map<String, Object> params = buildParameters(user);
		ParameterizedTypeReference<List<TimelineUserDto>> typeReference = new ParameterizedTypeReference<List<TimelineUserDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

}
