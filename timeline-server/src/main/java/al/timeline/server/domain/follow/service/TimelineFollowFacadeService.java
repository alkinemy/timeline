package al.timeline.server.domain.follow.service;

import al.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import al.timeline.server.domain.activity.service.ActivityEventProducer;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.domain.follow.dto.TimelineFollowDeleteForm;
import al.timeline.server.domain.follow.dto.TimelineFollowInsertForm;
import al.timeline.server.domain.follow.model.TimelineFollowEntity;
import al.timeline.server.domain.common.user.TimelineUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimelineFollowFacadeService {

	@Autowired
	private TimelineFollowQueryService timelineFollowQueryService;
	@Autowired
	private TimelineFollowCommandService timelineFollowCommandService;

	@Autowired
	private ActivityEventProducer activityEventProducer;

	@Autowired
	private SmartAssembler assembler;

	@Transactional(readOnly = true)
	public List<TimelineUser> getFollowings(String loginId) {
		List<TimelineFollowEntity> follows = timelineFollowQueryService.findAllByFollowerLoginId(loginId);
		return follows.stream()
			.filter(follow -> !StringUtils.equals(follow.getFollowing().getLoginId(), loginId))
			.map(TimelineFollowEntity::getFollowing).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<TimelineUser> getFollowers(String loginId) {
		List<TimelineFollowEntity> follows = timelineFollowQueryService.findAllByFollowingLoginId(loginId);
		return follows.stream()
			.filter(follow -> !StringUtils.equals(follow.getFollower().getLoginId(), loginId))
			.map(TimelineFollowEntity::getFollower).collect(Collectors.toList());
	}

	@Transactional
	public void insert(TimelineFollowInsertForm insertForm) {
		TimelineFollowEntity timelineFollowEntity = assembler.assemble(insertForm, TimelineFollowEntity.class);
		timelineFollowCommandService.insert(timelineFollowEntity);

		if (!StringUtils.equals(insertForm.getFollower().getLoginId(), insertForm.getFollowing().getLoginId())) {
			FollowCreatedEventForm followCreatedEventForm = assembler.assemble(insertForm, FollowCreatedEventForm.class);
			activityEventProducer.triggerFollowCreatedEvent(followCreatedEventForm);
		}
	}

	@Transactional
	public void delete(TimelineFollowDeleteForm deleteForm) {
		timelineFollowCommandService.delete(deleteForm.getFollower().getLoginId(), deleteForm.getFollowing().getLoginId());
	}

}
