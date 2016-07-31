package com.lezhin.timeline.member.domain.user.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.member.domain.user.model.TimelineUser;
import com.lezhin.timeline.member.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.member.interfaces.api.user.dto.TimelineUserInsertForm;
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
		entity.setPassword(insertForm.getPassword()); //TODO 암호화
		return entity;
	}

}
