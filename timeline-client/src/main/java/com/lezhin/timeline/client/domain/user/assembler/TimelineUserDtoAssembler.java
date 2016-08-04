package com.lezhin.timeline.client.domain.user.assembler;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import org.springframework.stereotype.Component;

@Component
public class TimelineUserDtoAssembler extends AbstractAssembler<TimelineUser, TimelineUserDto> {

	@Override
	protected TimelineUserDto doAssemble(TimelineUser user) {
		return TimelineUserDto.of(user.getLoginId(), user.getName());
	}

}
