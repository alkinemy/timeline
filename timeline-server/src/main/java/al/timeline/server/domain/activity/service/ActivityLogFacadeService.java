package al.timeline.server.domain.activity.service;

import al.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import al.timeline.server.domain.activity.model.ActivityLogEntity;
import al.timeline.server.domain.activity.model.FollowerCreatedActivityLogEntity;
import al.timeline.server.domain.activity.model.FollowingCreatedActivityLogEntity;
import al.timeline.server.domain.activity.model.MessageCreatedActivityLogEntity;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.domain.common.user.TimelineUser;
import al.timeline.server.domain.follow.service.TimelineFollowFacadeService;
import al.timeline.server.domain.message.model.TimelineMessageEntity;
import al.timeline.server.domain.message.service.TimelineMessageFacadeService;
import org.apache.commons.lang3.StringUtils;
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

	@Transactional
	public void logFollowerCreatedEvent(FollowCreatedEventForm form) {
		if (StringUtils.equals(form.getFollower().getLoginId(), form.getFollowing().getLoginId())) {
			return; //가입으로 팔로우 관계가 추가되는 경우 로그를 남기지 않는다
		}

		FollowerCreatedActivityLogEntity followerCreated = assembler.assemble(form, FollowerCreatedActivityLogEntity.class);
		activityLogCommandService.insert(followerCreated);

		FollowingCreatedActivityLogEntity followingCreated = assembler.assemble(form, FollowingCreatedActivityLogEntity.class);
		activityLogCommandService.insert(followingCreated);
	}

	@Transactional
	public void logTimelineMessageCreatedEvent(String messageId) {
		TimelineMessageEntity message = timelineMessageFacadeService.getTimelineMessage(messageId);
		TimelineUser from = message.getAuthor();
		timelineFollowFacadeService.getFollowers(from.getLoginId())
			.forEach(followingUser -> {
				MessageCreatedActivityLogEntity messageCreated = new MessageCreatedActivityLogEntity();
				messageCreated.setFrom(from);
				messageCreated.setTo(followingUser);
				messageCreated.setMessageId(messageId);
				activityLogCommandService.insert(messageCreated);
			});
	}

	public Page<ActivityLogEntity> getActivityLogs(String loginId, Pageable pageable) {
		return activityLogQueryService.findAllByToLoginId(loginId, pageable);
	}

}
