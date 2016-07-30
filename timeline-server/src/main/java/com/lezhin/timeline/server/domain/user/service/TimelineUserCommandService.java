package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.domain.user.repository.TimelineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserCommandService {

	@Autowired
	private TimelineUserRepository timelineUserRepository;

	public void insert(TimelineUserEntity entity) {
		entity.getFollowings().add(entity);
		timelineUserRepository.save(entity);
	}

}
