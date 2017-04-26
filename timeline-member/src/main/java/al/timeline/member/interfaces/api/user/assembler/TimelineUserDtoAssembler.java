package al.timeline.member.interfaces.api.user.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.member.domain.base.assembler.SmartAssembler;
import al.timeline.member.domain.user.model.TimelineUserEntity;
import al.timeline.member.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineUserDtoAssembler extends AbstractAssembler<TimelineUserEntity, TimelineUserDto> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected TimelineUserDto doAssemble(TimelineUserEntity entity) {
		TimelineUserDto dto = assembler.assemble(entity.getUser(), TimelineUserDto.class);
		return dto;
	}

}
