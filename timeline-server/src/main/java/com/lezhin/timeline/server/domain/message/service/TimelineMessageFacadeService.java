package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.common.domain.base.exception.Exceptions;
import com.lezhin.timeline.server.domain.activity.service.ActivityEventProducer;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.base.exception.TimelineServerErrorCode;
import com.lezhin.timeline.server.domain.message.dto.NewsFeedConditions;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.dto.TimelineUserMessageSearchConditions;
import com.lezhin.timeline.server.domain.message.dto.TimelineUserMessagesSearchConditions;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineUserMessagesSearchContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public TimelineMessageEntity getTimelineMessage(TimelineUserMessageSearchConditions conditions) {
		return timelineMessageQueryService.findOne(conditions.toPredicate()).orElse(null);
	}

	public TimelineMessageEntity getTimelineMessage(String messageId) {
		return timelineMessageQueryService.findOne(messageId)
			.orElseThrow(() -> Exceptions.newException(TimelineServerErrorCode.ENTITY_NOT_FOUND, messageId));
	}

	public List<TimelineMessageEntity> getTimelineUserMessages(TimelineUserMessagesSearchConditions userMessageParam) {
		TimelineUserMessagesSearchContext context = TimelineUserMessagesSearchContext.of(this);
		Pageable pageable = new PageRequest(0, userMessageParam.getSize(), Sort.Direction.DESC, "id");
		return timelineMessageQueryService.findAll(userMessageParam.toPredicate(context), pageable);
	}

	public List<TimelineMessageEntity> getNewsFeed(TimelineUserMessagesSearchConditions userMessageParam) {
		NewsFeedConditions condition = assembler.assemble(userMessageParam, NewsFeedConditions.class);
		return timelineMessageQueryService.findFollowingMessages(condition);
	}

}
