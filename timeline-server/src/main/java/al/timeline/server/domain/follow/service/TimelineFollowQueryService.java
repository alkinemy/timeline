package al.timeline.server.domain.follow.service;

import al.timeline.server.domain.follow.model.TimelineFollowEntity;
import al.timeline.server.domain.follow.repository.TimelineFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineFollowQueryService {

	@Autowired
	private TimelineFollowRepository timelineFollowRepository;

	public List<TimelineFollowEntity> findAllByFollowerLoginId(String loginId) {
		return timelineFollowRepository.findAllByFollowerLoginId(loginId);
	}

	public List<TimelineFollowEntity> findAllByFollowingLoginId(String loginId) {
		return timelineFollowRepository.findAllByFollowingLoginId(loginId);
	}

}
