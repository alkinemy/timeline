package al.timeline.member.domain.user.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.member.domain.user.model.TimelineUser;
import al.timeline.member.domain.user.model.TimelineUserEntity;
import al.timeline.member.domain.user.dto.TimelineUserInsertForm;
import org.springframework.stereotype.Component;

@Component
public class TimelineUserEntityAssembler extends AbstractAssembler<TimelineUserInsertForm, TimelineUserEntity> {

	@Override
	protected TimelineUserEntity doAssemble(TimelineUserInsertForm insertForm) {
		TimelineUserEntity entity = new TimelineUserEntity();
		TimelineUser user = new TimelineUser();
		user.setLoginId(insertForm.getLoginId());
		user.setName(insertForm.getName());
		entity.setUser(user);
		entity.setPassword(insertForm.getPassword());
		return entity;
	}

}
