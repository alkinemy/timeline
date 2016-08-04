package com.lezhin.timeline.server.interfaces.api.activity.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractListAssembler;
import com.lezhin.timeline.server.domain.activity.model.ActivityLogEntity;
import com.lezhin.timeline.server.domain.activity.model.MessageCreatedActivityLogEntity;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.interfaces.api.activity.dto.ActivityLogDto;
import com.lezhin.timeline.server.interfaces.api.activity.dto.DefaultActivityLogDto;
import com.lezhin.timeline.server.interfaces.api.activity.dto.MessageCreatedActivityLogDto;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
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
