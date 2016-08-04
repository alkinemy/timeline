package com.lezhin.timeline.member.interfaces.api.user.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.member.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.member.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.member.interfaces.api.user.dto.TimelineUserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineUserDetailsDtoAssembler extends AbstractAssembler<TimelineUserEntity, TimelineUserDetailsDto> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected TimelineUserDetailsDto doAssemble(TimelineUserEntity entity) {
		TimelineUserDetailsDto dto = assembler.assemble(entity.getUser(), TimelineUserDetailsDto.class);
		dto.setPassword(entity.getPassword());
		return dto;
	}

}
