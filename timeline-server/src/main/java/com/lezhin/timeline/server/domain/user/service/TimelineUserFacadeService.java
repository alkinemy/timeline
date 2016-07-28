package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserQueryService timelineUserQueryService;

	public TimelineUserEntity getTimelineUser(String loginId) {
		return timelineUserQueryService.findOneByLoginId(loginId).orElseThrow(() -> new RuntimeException("No timeline user exist")); //TODO 에러 처리;
	}

}
