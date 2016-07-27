package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TimelineMessageFacadeService {

	@Autowired
	private TimelineMessageCommandService timelineMessageCommandService;

	@Autowired
	private TimelineMessageIdService timelineMessageIdService;

	@Autowired
	private TimelineMessageQueryService timelineMessageQueryService;

	@Autowired
	private SmartAssembler assembler;

	public void insert(TimelineMessageInsertForm insertForm) {
		TimelineMessageEntity message = createTimelineMessage(insertForm);
		timelineMessageCommandService.insert(message);
		log.debug("Timeline message inserted, ID: {}", message.getMessageId());
	}

	private TimelineMessageEntity createTimelineMessage(TimelineMessageInsertForm insertForm) {
		TimelineMessageEntity message = assembler.assemble(insertForm, TimelineMessageEntity.class);
		message.setMessageId(timelineMessageIdService.generate());
		return message;
	}

	public List<TimelineMessageEntity> findAll(TimelineUser user) {
		return timelineMessageQueryService.findAll(user);
	}

}
