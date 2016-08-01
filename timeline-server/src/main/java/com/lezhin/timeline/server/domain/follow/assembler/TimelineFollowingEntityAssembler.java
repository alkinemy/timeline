package com.lezhin.timeline.server.domain.follow.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import com.lezhin.timeline.server.domain.follow.dto.TimelineFollowingInsertForm;
import com.lezhin.timeline.server.domain.follow.model.TimelineFollowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineFollowingEntityAssembler extends AbstractAssembler<TimelineFollowingInsertForm, TimelineFollowEntity> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected TimelineFollowEntity doAssemble(TimelineFollowingInsertForm insertForm) {
		TimelineFollowEntity entity = new TimelineFollowEntity();
		entity.setFollower(assembler.assemble(insertForm.getFollower(), TimelineUser.class));
		entity.setFollowing(assembler.assemble(insertForm.getFollowing(), TimelineUser.class));
		return entity;
	}

}
