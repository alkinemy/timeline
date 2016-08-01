package com.lezhin.timeline.member.interfaces.api.user.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.common.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.member.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.member.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineUserDtoAssembler extends AbstractAssembler<TimelineUserEntity, TimelineUserDto> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected TimelineUserDto doAssemble(TimelineUserEntity entity) {
		TimelineUserDto dto = assembler.assemble(entity.getUser(), TimelineUserDto.class);
		dto.setPassword(entity.getPassword());
		return dto;
	}

}
