package al.timeline.server.domain.activity.service;

import al.timeline.server.domain.activity.model.ActivityLogEntity;
import al.timeline.server.domain.activity.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogCommandService {

	@Autowired
	private ActivityLogRepository activityLogRepository;

	public void insert(ActivityLogEntity activityLogEntity) {
		activityLogRepository.save(activityLogEntity);
	}

}
