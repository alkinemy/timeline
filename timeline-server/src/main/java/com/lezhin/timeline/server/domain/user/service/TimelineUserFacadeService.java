package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.base.exception.Exceptions;
import com.lezhin.timeline.server.domain.base.exception.TimelineErrorCode;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserQueryService timelineUserQueryService;

	public TimelineUserEntity getTimelineUser(String loginId) {
		return timelineUserQueryService.findOneByLoginId(loginId)
			.orElseThrow(() -> Exceptions.newException(TimelineErrorCode.ENTITY_NOT_FOUND, loginId));
	}

	@Transactional(readOnly = true)
	public List<TimelineUserEntity> getFollowings(String loginId) {
		TimelineUserEntity timelineUser = getTimelineUser(loginId);
		timelineUser.getFollowings().size(); //TODO 강제 로딩을 위해 호출
		return timelineUser.getFollowings();
	}

}
