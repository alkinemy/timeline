package al.timeline.server.domain.activity.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import al.timeline.server.domain.activity.model.FollowerCreatedActivityLogEntity;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.domain.common.user.TimelineUser;
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
