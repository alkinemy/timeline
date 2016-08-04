package com.lezhin.timeline.client.domain.activity.service;

import com.lezhin.timeline.client.domain.activity.dto.ActivityLogDto;
import com.lezhin.timeline.client.domain.activity.dto.ActivityLogSearchConditions;
import com.lezhin.timeline.client.domain.base.adapter.TimelineServerAdapterBase;
import com.lezhin.timeline.client.web.base.response.PagedResources;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ActivityLogAdapterService extends TimelineServerAdapterBase {

	public PagedResources<ActivityLogDto> getActivityLogs(ActivityLogSearchConditions conditions) {
		String url = new StringBuilder().append(getBaseUrl()).append("/activities")
			.append("?loginId={loginId}").append("&page={page}").append("&size={size}").toString();
		Map<String, Object> params = new HashMap<>();
		params.put("loginId", conditions.getLoginId());
		params.put("page", conditions.getPage());
		params.put("size", conditions.getSize());
		ParameterizedTypeReference<PagedResources<ActivityLogDto>> typeReference = new ParameterizedTypeReference<PagedResources<ActivityLogDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

}
