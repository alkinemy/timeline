package al.timeline.server.domain.follow.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.domain.follow.dto.TimelineFollowInsertForm;
import al.timeline.server.domain.follow.model.TimelineFollowEntity;
import al.timeline.server.domain.common.user.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineFollowEntityAssembler extends AbstractAssembler<TimelineFollowInsertForm, TimelineFollowEntity> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected TimelineFollowEntity doAssemble(TimelineFollowInsertForm insertForm) {
		TimelineFollowEntity entity = new TimelineFollowEntity();
		entity.setFollower(assembler.assemble(insertForm.getFollower(), TimelineUser.class));
		entity.setFollowing(assembler.assemble(insertForm.getFollowing(), TimelineUser.class));
		return entity;
	}

}
