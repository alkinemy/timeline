package com.lezhin.timeline.client.domain.activity.service;

import com.lezhin.timeline.client.domain.activity.dto.ActivityLogDto;
import com.lezhin.timeline.client.domain.activity.dto.ActivityLogSearchConditions;
import com.lezhin.timeline.client.domain.base.rest.TimelineServerAdapterBase;
import com.lezhin.timeline.client.web.base.response.PagedResources;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActivityLogAdapterService extends TimelineServerAdapterBase {

	public PagedResources<ActivityLogDto> getActivityLogs(ActivityLogSearchConditions conditions) {
		String url = buildUrl("/activities", conditions);
		Map<String, Object> params = buildParameters(conditions);
		ParameterizedTypeReference<PagedResources<ActivityLogDto>> typeReference = new ParameterizedTypeReference<PagedResources<ActivityLogDto>>() { };
		return doWithRetry(context -> getRestTemplate().exchange(url, HttpMethod.GET, null, typeReference, params).getBody());
	}

}
