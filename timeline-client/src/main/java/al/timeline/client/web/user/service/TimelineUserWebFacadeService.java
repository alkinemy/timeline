package al.timeline.client.web.user.service;

import al.timeline.client.domain.activity.dto.ActivityLogDto;
import al.timeline.client.domain.activity.dto.ActivityLogSearchConditions;
import al.timeline.client.domain.user.model.TimelineUser;
import al.timeline.client.domain.user.service.TimelineUserFacadeService;
import al.timeline.client.web.base.response.PagedResources;
import al.timeline.client.domain.activity.service.ActivityLogFacadeService;
import al.timeline.client.domain.base.assembler.SmartAssembler;
import al.timeline.client.domain.user.dto.TimelineUserDto;
import al.timeline.client.web.user.dto.ActivityLogSearchParam;
import al.timeline.client.web.user.dto.ActivityLogViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserWebFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;
	@Autowired
	private ActivityLogFacadeService activityLogFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public TimelineUserDto getUser(String loginId) {
		return timelineUserFacadeService.getUser(loginId);
	}

	public PagedResources<ActivityLogViewDto> getActivityLogs(TimelineUser user, ActivityLogSearchParam searchParam) {
		ActivityLogSearchConditions conditions = assembler.assemble(searchParam, ActivityLogSearchConditions.class);
		conditions.setLoginId(user.getLoginId());
		PagedResources<ActivityLogDto> activityLogs = activityLogFacadeService.getActivityLogs(conditions);
		return assembler.assemble(activityLogs, ActivityLogDto.class, ActivityLogViewDto.class);
	}

}
