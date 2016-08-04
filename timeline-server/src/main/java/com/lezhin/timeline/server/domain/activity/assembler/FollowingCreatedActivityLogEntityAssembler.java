package com.lezhin.timeline.server.domain.activity.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import com.lezhin.timeline.server.domain.activity.model.FollowingCreatedActivityLogEntity;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FollowingCreatedActivityLogEntityAssembler extends AbstractAssembler<FollowCreatedEventForm, FollowingCreatedActivityLogEntity> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected FollowingCreatedActivityLogEntity doAssemble(FollowCreatedEventForm eventForm) {
		FollowingCreatedActivityLogEntity entity = new FollowingCreatedActivityLogEntity();
		entity.setFrom(assembler.assemble(eventForm.getFollower(), TimelineUser.class));
		entity.setTo(assembler.assemble(eventForm.getFollowing(), TimelineUser.class));
		return entity;
	}

}
