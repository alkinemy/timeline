package al.timeline.member.interfaces.api.user.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.member.domain.base.assembler.SmartAssembler;
import al.timeline.member.domain.user.model.TimelineUserEntity;
import al.timeline.member.interfaces.api.user.dto.TimelineUserDetailsDto;
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
