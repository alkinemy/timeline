package al.timeline.server.interfaces.api.activity.assembler;

import al.timeline.common.domain.base.assembler.AbstractListAssembler;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.interfaces.api.activity.dto.ActivityLogDto;
import al.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import al.timeline.server.domain.activity.model.ActivityLogEntity;
import al.timeline.server.domain.activity.model.MessageCreatedActivityLogEntity;
import al.timeline.server.interfaces.api.activity.dto.DefaultActivityLogDto;
import al.timeline.server.interfaces.api.activity.dto.MessageCreatedActivityLogDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityLogDtoAssembler extends AbstractListAssembler<ActivityLogEntity, ActivityLogDto> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected ActivityLogDto doAssemble(ActivityLogEntity entity) {
		if (entity instanceof MessageCreatedActivityLogEntity) {
			MessageCreatedActivityLogDto dto = new MessageCreatedActivityLogDto();
			BeanUtils.copyProperties(entity, dto);
			dto.setFrom(assembler.assemble(entity.getFrom(), TimelineUserDto.class));
			dto.setMessageId(((MessageCreatedActivityLogEntity) entity).getMessageId());
			return dto;
		} else {
			DefaultActivityLogDto dto = new DefaultActivityLogDto();
			BeanUtils.copyProperties(entity, dto);
			dto.setFrom(assembler.assemble(entity.getFrom(), TimelineUserDto.class));
			return dto;
		}
	}

}
