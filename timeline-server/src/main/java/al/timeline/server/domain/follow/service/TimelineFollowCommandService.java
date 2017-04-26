package al.timeline.server.domain.follow.service;

import al.timeline.server.domain.follow.model.TimelineFollowEntity;
import al.timeline.server.domain.follow.repository.TimelineFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimelineFollowCommandService {

	@Autowired
	private TimelineFollowRepository timelineFollowRepository;

	public void insert(TimelineFollowEntity timelineFollowEntity) {
		timelineFollowRepository.save(timelineFollowEntity);
	}

	@Transactional
	public void delete(String followerLoginId, String followingLoginId) {
		timelineFollowRepository.findOneByFollowerLoginIdAndFollowingLoginId(followerLoginId, followingLoginId)
			.ifPresent(timelineFollowEntity -> timelineFollowRepository.delete(timelineFollowEntity));
	}
}
