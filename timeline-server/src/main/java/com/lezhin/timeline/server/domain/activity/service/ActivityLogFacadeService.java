package com.lezhin.timeline.server.domain.activity.service;

import com.lezhin.timeline.server.domain.activity.dto.FollowingCreatedEventForm;
import com.lezhin.timeline.server.domain.activity.model.ActivityLogEntity;
import com.lezhin.timeline.server.domain.activity.model.ActivityType;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import com.lezhin.timeline.server.domain.follow.service.TimelineFollowFacadeService;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.service.TimelineMessageFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityLogFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;
	@Autowired
	private TimelineFollowFacadeService timelineFollowFacadeService;

	@Autowired
	private ActivityLogQueryService activityLogQueryService;
	@Autowired
	private ActivityLogCommandService activityLogCommandService;

	@Autowired
	private SmartAssembler assembler;

	public void logFollowingCreatedEvent(FollowingCreatedEventForm form) {
		ActivityLogEntity activityLog = assembler.assemble(form, ActivityLogEntity.class);
		activityLog.setType(ActivityType.FOLLOWER_CREATED);

		//TODO base url을 넣자
		StringBuilder url = new StringBuilder();
		url.append("/").append(form.getFollowing().getLoginId());
		activityLog.setLinkUrl(url.toString());

		activityLogCommandService.insert(activityLog);
	}

	@Transactional
	public void logTimelineMessageCreatedEvent(String messageId) {
		TimelineMessageEntity message = timelineMessageFacadeService.getTimelineMessage(messageId);
		//TODO base url을 넣자
		TimelineUser from = message.getAuthor();
		String url = new StringBuilder().append("/").append(messageId).toString();

		timelineFollowFacadeService.getFollowings(from.getLoginId())
			.forEach(followingUser -> {
				ActivityLogEntity activityLog = new ActivityLogEntity();
				activityLog.setFrom(from);
				activityLog.setTo(followingUser);
				activityLog.setType(ActivityType.MESSAGE_CREATED);
				activityLog.setLinkUrl(url);
				activityLogCommandService.insert(activityLog);
			});
	}

	public Page<ActivityLogEntity> getActivityLogs(String loginId, Pageable pageable) {
		return activityLogQueryService.findAllByToLoginId(loginId, pageable);
	}
}
