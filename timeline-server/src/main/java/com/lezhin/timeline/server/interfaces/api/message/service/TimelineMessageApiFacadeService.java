package com.lezhin.timeline.server.interfaces.api.message.service;

import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.service.TimelineMessageFacadeService;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageInsertApiForm;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineMessageApiFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public void postMessage(TimelineMessageInsertApiForm insertApiForm) {
		TimelineMessageInsertForm insertForm = assembler.assemble(insertApiForm, TimelineMessageInsertForm.class);
		timelineMessageFacadeService.insert(insertForm);
	}

	public List<TimelineMessageDto> listMessages(TimelineUserDto user) {
		List<TimelineMessageEntity> timelineMessages = timelineMessageFacadeService.getTimelineMessages(user.getLoginId());
		return assembler.assemble(timelineMessages, TimelineMessageDto.class);
	}
}
