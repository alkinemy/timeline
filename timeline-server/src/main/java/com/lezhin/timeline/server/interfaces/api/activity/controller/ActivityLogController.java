package com.lezhin.timeline.server.interfaces.api.activity.controller;

import com.lezhin.timeline.server.interfaces.api.activity.dto.ActivityLogDto;
import com.lezhin.timeline.server.interfaces.api.activity.service.ActivityLogApiFacadeService;
import com.lezhin.timeline.server.interfaces.api.base.response.PagedResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{loginId}/activities")
public class ActivityLogController {

	@Autowired
	private ActivityLogApiFacadeService activityLogApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public PagedResources<ActivityLogDto> getActivityLogs(@PathVariable String loginId, Pageable pageable) {
		return activityLogApiFacadeService.getActivityLogs(loginId, pageable);
	}

}
