package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.domain.user.repository.TimelineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimelineUserQueryService {

	@Autowired
	private TimelineUserRepository timelineUserRepository;

	public Optional<TimelineUserEntity> findOneByLoginId(String loginId) {
		return timelineUserRepository.findOneByLoginId(loginId);
	}

}
