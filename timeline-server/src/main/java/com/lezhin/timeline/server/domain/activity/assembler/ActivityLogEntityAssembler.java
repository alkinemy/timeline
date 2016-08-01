package com.lezhin.timeline.server.domain.activity.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.common.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.activity.dto.FollowingCreatedEventForm;
import com.lezhin.timeline.server.domain.activity.model.ActivityLogEntity;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityLogEntityAssembler extends AbstractAssembler<FollowingCreatedEventForm, ActivityLogEntity> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected ActivityLogEntity doAssemble(FollowingCreatedEventForm eventForm) {
		ActivityLogEntity entity = new ActivityLogEntity();
		entity.setFrom(assembler.assemble(eventForm.getFollower(), TimelineUser.class));
		entity.setTo(assembler.assemble(eventForm.getFollowing(), TimelineUser.class));
		return entity;
	}

}
