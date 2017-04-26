package al.timeline.server.domain.activity.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import al.timeline.server.domain.activity.model.FollowingCreatedActivityLogEntity;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.domain.common.user.TimelineUser;
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
