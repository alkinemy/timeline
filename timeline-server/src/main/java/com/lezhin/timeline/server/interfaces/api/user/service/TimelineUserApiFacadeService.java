package com.lezhin.timeline.server.interfaces.api.user.service;

import com.lezhin.timeline.server.domain.activity.model.ActivityLogEntity;
import com.lezhin.timeline.server.domain.activity.service.ActivityLogFacadeService;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.domain.user.service.TimelineUserFacadeService;
import com.lezhin.timeline.server.interfaces.api.base.response.PagedResources;
import com.lezhin.timeline.server.interfaces.api.user.dto.ActivityLogDto;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserApiFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;
	@Autowired
	private ActivityLogFacadeService activityLogFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public TimelineUserDto getTimelineUser(String loginId) {
		TimelineUserEntity timelineUserEntity = timelineUserFacadeService.getTimelineUser(loginId);
		return assembler.assemble(timelineUserEntity.getUser(), TimelineUserDto.class);
	}

	public void register(TimelineUserInsertForm insertForm) {
		timelineUserFacadeService.insert(insertForm);
	}

	public PagedResources<ActivityLogDto> getActivityLogs(String loginId, Pageable pageable) {
		Page<ActivityLogEntity> activityLogEntities = activityLogFacadeService.getActivityLogs(loginId, pageable);
		Page<ActivityLogDto> activityLogs = assembler.assemble(pageable, activityLogEntities, ActivityLogDto.class);
		return new PagedResources<>(activityLogs);
	}

}

