package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.activity.service.ActivityEventProducer;
import com.lezhin.timeline.server.domain.user.dto.FollowingInsertForm;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.interfaces.api.follow.service.FollowDeleteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FollowFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Autowired
	private ActivityEventProducer activityEventProducer;

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

		activityEventProducer.triggerFollowerCreatedEvent(insertForm.getLoginId(), insertForm.getFollowingLoginId());
	}

	@Transactional
	public void delete(FollowDeleteForm deleteForm) {
		//TODO 그냥 직접 지우는게 빠를것같음
		TimelineUserEntity timelineUser = timelineUserFacadeService.getTimelineUser(deleteForm.getLoginId());
		timelineUser.getFollowings().stream()
			.filter(following -> deleteForm.getLoginId().equals(following.getUser().getLoginId()))
			.forEach(following -> timelineUser.getFollowings().remove(following));
	}
}
