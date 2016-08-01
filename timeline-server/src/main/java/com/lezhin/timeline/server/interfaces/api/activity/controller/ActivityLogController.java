package com.lezhin.timeline.server.interfaces.api.activity.controller;

import com.lezhin.timeline.server.interfaces.api.activity.dto.ActivityLogDto;
import com.lezhin.timeline.server.interfaces.api.activity.service.ActivityLogApiFacadeService;
import com.lezhin.timeline.server.interfaces.api.base.response.PagedResources;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
public class ActivityLogController {

	@Autowired
	private ActivityLogApiFacadeService activityLogApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public PagedResources<ActivityLogDto> getActivityLogs(TimelineUserDto user, Pageable pageable) {
		return activityLogApiFacadeService.getActivityLogs(user, pageable);
	}

}
