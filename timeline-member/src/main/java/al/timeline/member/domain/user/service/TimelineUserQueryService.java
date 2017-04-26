package al.timeline.member.domain.user.service;

import al.timeline.member.domain.user.model.TimelineUserEntity;
import al.timeline.member.domain.user.repository.TimelineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TimelineUserQueryService {

	@Autowired
	private TimelineUserRepository timelineUserRepository;

	@Transactional(readOnly = true)
	public Optional<TimelineUserEntity> findOneByLoginId(String loginId) {
		return timelineUserRepository.findOneByUserLoginId(loginId);
	}

}
