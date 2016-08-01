package com.lezhin.timeline.server.domain.follow.service;

import com.lezhin.timeline.server.domain.activity.dto.FollowingCreatedEventForm;
import com.lezhin.timeline.server.domain.activity.service.ActivityEventProducer;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import com.lezhin.timeline.server.domain.follow.dto.TimelineFollowDeleteForm;
import com.lezhin.timeline.server.domain.follow.dto.TimelineFollowingInsertForm;
import com.lezhin.timeline.server.domain.follow.model.TimelineFollowEntity;
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
		return follows.stream().map(TimelineFollowEntity::getFollowing).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public void insert(TimelineFollowingInsertForm insertForm) {
		TimelineFollowEntity timelineFollowEntity = assembler.assemble(insertForm, TimelineFollowEntity.class);
		timelineFollowCommandService.insert(timelineFollowEntity);

		FollowingCreatedEventForm followingCreatedEventForm = assembler.assemble(insertForm, FollowingCreatedEventForm.class);
		activityEventProducer.triggerFollowerCreatedEvent(followingCreatedEventForm);
	}

	@Transactional
	public void delete(TimelineFollowDeleteForm deleteForm) {
		timelineFollowCommandService.delete(deleteForm.getFollowerLoginId(), deleteForm.getFollowingLoginId());
	}

}
