package al.timeline.server.domain.activity.service;

import al.timeline.server.domain.activity.model.ActivityLogEntity;
import al.timeline.server.domain.activity.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogQueryService {

	@Autowired
	private ActivityLogRepository activityLogRepository;

	public Page<ActivityLogEntity> findAllByToLoginId(String loginId, Pageable pageable) {
		return activityLogRepository.findAllByToLoginId(loginId, pageable);
	}

}
