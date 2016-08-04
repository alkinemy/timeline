package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.base.rest.TimelineUserAdapterBase;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDetailsDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserRegisterForm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TimelineUserAdapterService extends TimelineUserAdapterBase {

	public TimelineUserDto getUser(String loginId) {
		String url = buildUrl("/users/{loginId}");
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return doWithRetry(context -> getRestTemplate().getForObject(url, TimelineUserDto.class, params));
	}

	public TimelineUserDetailsDto getUserDetails(String loginId) {
		String url = buildUrl("/users/{loginId}");
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return doWithRetry(context -> getRestTemplate().getForObject(url, TimelineUserDetailsDto.class, params));
	}

	public void registerUser(TimelineUserRegisterForm insertForm) {
		String url = buildUrl("/users");
		doWithRetry(context -> getRestTemplate().postForObject(url, insertForm, Void.class));
	}

}
