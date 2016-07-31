package com.lezhin.timeline.server.interfaces.api.activity.service;

import com.lezhin.timeline.server.domain.activity.model.ActivityLogEntity;
import com.lezhin.timeline.server.domain.activity.service.ActivityLogFacadeService;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.interfaces.api.activity.dto.ActivityLogDto;
import com.lezhin.timeline.server.interfaces.api.base.response.PagedResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogApiFacadeService {

	@Autowired
	private ActivityLogFacadeService activityLogFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public PagedResources<ActivityLogDto> getActivityLogs(String loginId, Pageable pageable) {
		Page<ActivityLogEntity> activityLogEntities = activityLogFacadeService.getActivityLogs(loginId, pageable);
		Page<ActivityLogDto> activityLogs = assembler.assemble(pageable, activityLogEntities, ActivityLogDto.class);
		return new PagedResources<>(activityLogs);
	}

}

