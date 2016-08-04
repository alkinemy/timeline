package com.lezhin.timeline.server.domain.activity.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import com.lezhin.timeline.server.domain.activity.model.FollowerCreatedActivityLogEntity;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FollowerCreatedActivityLogEntityAssembler extends AbstractAssembler<FollowCreatedEventForm, FollowerCreatedActivityLogEntity> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected FollowerCreatedActivityLogEntity doAssemble(FollowCreatedEventForm eventForm) {
		FollowerCreatedActivityLogEntity entity = new FollowerCreatedActivityLogEntity();
		entity.setFrom(assembler.assemble(eventForm.getFollowing(), TimelineUser.class));
		entity.setTo(assembler.assemble(eventForm.getFollower(), TimelineUser.class));
		return entity;
	}

}
