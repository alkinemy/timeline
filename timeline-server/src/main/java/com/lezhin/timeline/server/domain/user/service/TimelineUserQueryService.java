package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import com.lezhin.timeline.server.domain.user.repository.TimelineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserQueryService {

	@Autowired
	private TimelineUserRepository timelineUserRepository;

	public TimelineUser findOneByLoginId(String loginId) {
		return timelineUserRepository.findOneByLoginId(loginId);
	}

}
