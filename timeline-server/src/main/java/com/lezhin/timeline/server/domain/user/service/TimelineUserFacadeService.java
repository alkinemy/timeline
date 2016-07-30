package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.base.exception.Exceptions;
import com.lezhin.timeline.server.domain.base.exception.TimelineErrorCode;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserQueryService timelineUserQueryService;

	public TimelineUserEntity getTimelineUser(String loginId) {
		return timelineUserQueryService.findOneByLoginId(loginId)
			.orElseThrow(() -> Exceptions.newException(TimelineErrorCode.ENTITY_NOT_FOUND, loginId));
	}

}
