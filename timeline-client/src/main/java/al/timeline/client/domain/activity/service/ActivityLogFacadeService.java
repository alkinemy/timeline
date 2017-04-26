package al.timeline.client.domain.activity.service;

import al.timeline.client.domain.activity.dto.ActivityLogSearchConditions;
import al.timeline.client.web.base.response.PagedResources;
import al.timeline.client.domain.activity.dto.ActivityLogDto;
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
