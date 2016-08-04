package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.base.rest.TimelineMemberAdapterBase;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserInsertForm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TimelineUserAdapterService extends TimelineMemberAdapterBase {

	public TimelineUserDto getUser(String loginId) {
		String url = buildUrl("/users/{loginId}");
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", loginId);
		return doWithRetry(context -> getRestTemplate().getForObject(url, TimelineUserDto.class, params));
	}

	public void registerUser(TimelineUserInsertForm insertForm) {
		String url = buildUrl("/users");
		doWithRetry(context -> getRestTemplate().postForObject(url, insertForm, Void.class));
	}

}
