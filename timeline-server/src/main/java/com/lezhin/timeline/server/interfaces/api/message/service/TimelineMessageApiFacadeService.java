package com.lezhin.timeline.server.interfaces.api.message.service;

import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.dto.TimelineUserMessageSearchConditions;
import com.lezhin.timeline.server.domain.message.dto.TimelineUserMessagesSearchConditions;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.service.TimelineMessageFacadeService;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageInsertApiForm;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineUserMessageApiConditions;
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

	public List<TimelineMessageDto> listMessages(TimelineUserMessageApiConditions userMessageApiParam) {
		TimelineUserMessagesSearchConditions userMessageParam = assembler.assemble(userMessageApiParam, TimelineUserMessagesSearchConditions.class);
		List<TimelineMessageEntity> timelineMessages = timelineMessageFacadeService.getTimelineUserMessages(userMessageParam);
		return assembler.assemble(timelineMessages, TimelineMessageDto.class);
	}

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessageApiConditions userMessageApiParam) {
		TimelineUserMessagesSearchConditions userMessageParam = assembler.assemble(userMessageApiParam, TimelineUserMessagesSearchConditions.class);
		List<TimelineMessageEntity> timelineMessages = timelineMessageFacadeService.getNewsFeed(userMessageParam);
		return assembler.assemble(timelineMessages, TimelineMessageDto.class);
	}

	public TimelineMessageDto getMessage(String loginId, String messageId) {
		TimelineUserMessageSearchConditions conditions = TimelineUserMessageSearchConditions.of(loginId, messageId);
		TimelineMessageEntity timelineMessage = timelineMessageFacadeService.getTimelineMessage(conditions);
		return assembler.assemble(timelineMessage, TimelineMessageDto.class);
	}

}
