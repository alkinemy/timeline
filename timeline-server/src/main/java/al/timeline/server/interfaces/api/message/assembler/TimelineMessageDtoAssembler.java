package al.timeline.server.interfaces.api.message.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import al.timeline.server.domain.message.model.TimelineMessageEntity;
import al.timeline.server.interfaces.api.user.dto.TimelineUserDto;
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
		dto.setMessageDate(entity.getMessageDate());
		return dto;
	}

}
