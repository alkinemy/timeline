package al.timeline.server.interfaces.api.activity.service;

import al.timeline.server.domain.activity.model.ActivityLogEntity;
import al.timeline.server.domain.activity.service.ActivityLogFacadeService;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.interfaces.api.activity.dto.ActivityLogDto;
import al.timeline.server.interfaces.api.base.response.PagedResources;
import al.timeline.server.interfaces.api.user.dto.TimelineUserDto;
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

	public PagedResources<ActivityLogDto> getActivityLogs(TimelineUserDto user, Pageable pageable) {
		Page<ActivityLogEntity> activityLogEntities = activityLogFacadeService.getActivityLogs(user.getLoginId(), pageable);
		Page<ActivityLogDto> activityLogs = assembler.assemble(pageable, activityLogEntities, ActivityLogEntity.class, ActivityLogDto.class);
		return new PagedResources<>(activityLogs);
	}

}

