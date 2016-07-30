package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.activity.service.ActivityEventProducer;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.base.exception.Exceptions;
import com.lezhin.timeline.server.domain.base.exception.TimelineErrorCode;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageNewsFeedCondition;
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
	private TimelineMessageQueryService timelineMessageQueryService;
	@Autowired
	private TimelineMessageCommandService timelineMessageCommandService;

	@Autowired
	private TimelineMessageIdService timelineMessageIdService;

	@Autowired
	private ActivityEventProducer activityEventProducer;

	@Autowired
	private SmartAssembler assembler;

	public void insert(TimelineMessageInsertForm insertForm) {
		TimelineMessageEntity message = createTimelineMessage(insertForm);
		timelineMessageCommandService.insert(message);
		log.debug("Timeline message inserted, ID: {}", message.getMessageId());

		activityEventProducer.triggerTimelineMessageCreatedEvent(message.getMessageId());
	}

	private TimelineMessageEntity createTimelineMessage(TimelineMessageInsertForm insertForm) {
		TimelineMessageEntity message = assembler.assemble(insertForm, TimelineMessageEntity.class);
		message.setMessageId(timelineMessageIdService.generate());
		return message;
	}

	public List<TimelineMessageEntity> getTimelineMessages(TimelineUser user) {
		return timelineMessageQueryService.findAll(user);
	}

	public TimelineMessageEntity getTimelineMessage(String messageId) {
		return timelineMessageQueryService.findOne(messageId)
			.orElseThrow(() -> Exceptions.newException(TimelineErrorCode.ENTITY_NOT_FOUND, messageId));
	}

	public List<TimelineMessageEntity> getFollowingTimelineMessages(TimelineMessageNewsFeedCondition condition) {
		return timelineMessageQueryService.findFollowingTimelineMessages(condition);
	}

}
