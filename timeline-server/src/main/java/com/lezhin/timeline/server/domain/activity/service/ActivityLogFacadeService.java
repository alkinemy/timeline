package com.lezhin.timeline.server.domain.activity.service;

import com.lezhin.timeline.server.domain.activity.model.ActivityLogEntity;
import com.lezhin.timeline.server.domain.activity.model.ActivityType;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.service.TimelineMessageFacadeService;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.domain.user.service.TimelineUserFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityLogFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	@Autowired
	private ActivityLogQueryService activityLogQueryService;
	@Autowired
	private ActivityLogCommandService activityLogCommandService;

	@Transactional
	public void logFollowingCreatedEvent(String loginId, String followingLoginId) {
		TimelineUserEntity timelineUser = timelineUserFacadeService.getTimelineUser(loginId);
		TimelineUserEntity followingUser = timelineUserFacadeService.getTimelineUser(followingLoginId);

		ActivityLogEntity activityLog = new ActivityLogEntity();
		activityLog.setFrom(timelineUser.getUser());
		activityLog.setTo(followingUser.getUser());
		activityLog.setType(ActivityType.FOLLOWER_CREATED);

		//TODO base url을 넣자
		StringBuilder url = new StringBuilder();
		url.append("/").append(followingUser.getUser().getLoginId());
		activityLog.setLinkUrl(url.toString());

		activityLogCommandService.insert(activityLog);
	}

	@Transactional
	public void logTimelineMessageCreatedEvent(String messageId) {
		TimelineMessageEntity message = timelineMessageFacadeService.getTimelineMessage(messageId);
		TimelineUserEntity user = timelineUserFacadeService.getTimelineUser(message.getAuthor().getLoginId());
		//TODO base url을 넣자
		String url = new StringBuilder().append("/").append(messageId).toString();

		user.getFollowings().forEach(followingUser -> {
			ActivityLogEntity activityLog = new ActivityLogEntity();
			activityLog.setFrom(user.getUser());
			activityLog.setTo(followingUser.getUser());
			activityLog.setType(ActivityType.MESSAGE_CREATED);
			activityLog.setLinkUrl(url);
			activityLogCommandService.insert(activityLog);
		});
	}

	public Page<ActivityLogEntity> getActivityLogs(String loginId, Pageable pageable) {
		return activityLogQueryService.findAllByToLoginId(loginId, pageable);
	}

}
