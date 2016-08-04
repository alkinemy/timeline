package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.base.adapter.TimelineServerAdapterBase;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserFollowForm;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TimelineFollowAdapterService extends TimelineServerAdapterBase {

	public void addFollowing(TimelineUserFollowForm followForm) {
		String url = new StringBuilder().append(getBaseUrl()).append("/follows/follow").toString();
		doWithRetry(context -> getRestTemplate().postForObject(url, followForm, Void.class));
	}

	public void removeFollowing(TimelineUserFollowForm followForm) {
		String url = new StringBuilder().append(getBaseUrl()).append("/follows/unfollow").toString();
		doWithRetry(context -> getRestTemplate().postForObject(url, followForm, Void.class));
	}

	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		String url = new StringBuilder().append(getBaseUrl()).append("/follows/followings?loginId={loginId}&name={name}").toString();
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", user.getLoginId());
		params.put("name", user.getLoginId());
		ParameterizedTypeReference<List<TimelineUserDto>> typeReference = new ParameterizedTypeReference<List<TimelineUserDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

	public List<TimelineUserDto> getFollowers(TimelineUserDto user) {
		String url = new StringBuilder().append(getBaseUrl()).append("/follows/followers?loginId={loginId}&name={name}").toString();
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", user.getLoginId());
		params.put("name", user.getLoginId());
		ParameterizedTypeReference<List<TimelineUserDto>> typeReference = new ParameterizedTypeReference<List<TimelineUserDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

}
