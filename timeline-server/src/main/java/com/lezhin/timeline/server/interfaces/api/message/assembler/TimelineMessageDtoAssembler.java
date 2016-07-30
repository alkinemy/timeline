package com.lezhin.timeline.server.interfaces.api.message.assembler;

import com.lezhin.timeline.server.domain.base.assembler.ListAssembler;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimelineMessageDtoAssembler implements ListAssembler<TimelineMessageEntity, TimelineMessageDto> {

	//TODO implementation

	@Override
	public List<TimelineMessageDto> assemble(List<TimelineMessageEntity> entities) {
		return null;
	}

	@Override
	public TimelineMessageDto assemble(TimelineMessageEntity entity) {
		return null;
	}

}
