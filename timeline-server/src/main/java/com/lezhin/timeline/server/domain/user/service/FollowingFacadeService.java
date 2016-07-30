package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.user.dto.FollowingInsertForm;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowingFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Transactional(readOnly = true)
	public List<TimelineUserEntity> getFollowings(String loginId) {
		TimelineUserEntity timelineUser = timelineUserFacadeService.getTimelineUser(loginId);
		timelineUser.getFollowings().size(); //강제 로딩을 위해 호출
		return timelineUser.getFollowings();
	}

	@Transactional(readOnly = true)
	public void insert(FollowingInsertForm insertForm) {
		TimelineUserEntity timelineUser = timelineUserFacadeService.getTimelineUser(insertForm.getLoginId());
		TimelineUserEntity followingUser = timelineUserFacadeService.getTimelineUser(insertForm.getFollowingLoginId());
		timelineUser.getFollowings().add(followingUser);
	}
}
