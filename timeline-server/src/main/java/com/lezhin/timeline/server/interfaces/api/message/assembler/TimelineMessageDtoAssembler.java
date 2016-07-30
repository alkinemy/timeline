package com.lezhin.timeline.server.interfaces.api.message.assembler;

import com.lezhin.timeline.server.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineMessageDtoAssembler extends AbstractAssembler<TimelineMessageEntity,TimelineMessageDto> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected TimelineMessageDto doAssemble(TimelineMessageEntity entity) {
		TimelineMessageDto dto = new TimelineMessageDto();
		dto.setMessageId(entity.getMessageId());
		dto.setAuthor(assembler.assemble(entity.getAuthor(), TimelineUserDto.class));
		dto.setContents(entity.getContents());
		dto.setParentMessageId(entity.getParentMessageId());
		return dto;
	}

}
