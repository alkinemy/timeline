package com.lezhin.timeline.member.domain.user.service;

import com.lezhin.timeline.member.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.member.domain.user.repository.TimelineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserCommandService {

	@Autowired
	private TimelineUserRepository timelineUserRepository;

	public void insert(TimelineUserEntity entity) {
		timelineUserRepository.save(entity);
	}

}
