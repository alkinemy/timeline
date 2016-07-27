package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserQueryService timelineUserQueryService;

	public TimelineUser getTimelineUser(String loginId) {
		return timelineUserQueryService.findOneByLoginId(loginId);
	}

}
