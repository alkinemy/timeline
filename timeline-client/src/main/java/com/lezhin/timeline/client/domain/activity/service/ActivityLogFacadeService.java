package com.lezhin.timeline.client.domain.activity.service;

import com.lezhin.timeline.client.domain.activity.dto.ActivityLogDto;
import com.lezhin.timeline.client.domain.activity.dto.ActivityLogSearchConditions;
import com.lezhin.timeline.client.web.base.response.PagedResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogFacadeService {

	@Autowired
	private ActivityLogAdapterService activityLogAdapterService;

	public PagedResources<ActivityLogDto> getActivityLogs(ActivityLogSearchConditions conditions) {
		return activityLogAdapterService.getActivityLogs(conditions);
	}

}
