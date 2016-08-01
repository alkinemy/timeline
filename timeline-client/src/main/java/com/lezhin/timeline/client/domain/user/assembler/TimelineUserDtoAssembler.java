package com.lezhin.timeline.client.domain.user.assembler;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class TimelineUserDtoAssembler extends AbstractAssembler<User, TimelineUserDto> {

	@Override
	protected TimelineUserDto doAssemble(User user) {
		TimelineUserDto userDto = new TimelineUserDto();
		userDto.setLoginId(user.getUsername());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

}
