package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	public List<TimelineUserEntity> getFollowings(String loginId) {
		return timelineUserFacadeService.getFollowings(loginId);
	}

}
