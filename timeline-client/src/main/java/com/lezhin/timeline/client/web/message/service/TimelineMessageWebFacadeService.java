package com.lezhin.timeline.client.web.message.service;

import com.google.common.collect.Iterables;
import com.lezhin.timeline.client.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageSearchConditions;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessagesSearchConditions;
import com.lezhin.timeline.client.domain.message.service.TimelineMessageFacadeService;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.message.dto.TimelineMessageDtos;
import com.lezhin.timeline.client.web.message.dto.TimelineMessagePostWebForm;
import com.lezhin.timeline.client.web.message.dto.TimelineUserMessagesSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class TimelineMessageWebFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public void postMessage(TimelineUser user, TimelineMessagePostWebForm postWebForm) {
		TimelineMessagePostForm postForm = assembler.assemble(postWebForm, TimelineMessagePostForm.class);
		postForm.setUser(assembler.assemble(user, TimelineUserDto.class));
		timelineMessageFacadeService.postMessage(postForm);
	}

	public TimelineMessageDtos getNewsFeed(TimelineUser user, TimelineUserMessagesSearchParam userPageParam) {
		return getMessages(user.getLoginId(), userPageParam,
			userMessagesCondition -> timelineMessageFacadeService.getNewsFeed(userMessagesCondition));
	}

	public TimelineMessageDtos getMessages(String loginId, TimelineUserMessagesSearchParam userPageParam) {
		return getMessages(loginId, userPageParam,
			userMessagesCondition -> timelineMessageFacadeService.getMessages(userMessagesCondition));
	}

	private TimelineMessageDtos getMessages(
		String loginId, TimelineUserMessagesSearchParam userPageParam,
		Function<TimelineUserMessagesSearchConditions, List<TimelineMessageDto>> searchFunction) {

		TimelineUserMessagesSearchConditions searchConditions = assembler.assemble(userPageParam, TimelineUserMessagesSearchConditions.class);
		searchConditions.setLoginId(loginId);
		List<TimelineMessageDto> messages = searchFunction.apply(searchConditions);
		TimelineMessageDtos timelineMessageDtos = new TimelineMessageDtos();
		timelineMessageDtos.setMessages(messages);
		if (!messages.isEmpty()) {
			timelineMessageDtos.setLastTimelineMessageId(Iterables.getLast(messages).getMessageId());
		}
		return timelineMessageDtos;
	}

	public TimelineMessageDto getMessage(String loginId, String messageId) {
		TimelineUserMessageSearchConditions searchCondition = TimelineUserMessageSearchConditions.of(loginId, messageId);
		return timelineMessageFacadeService.getMessage(searchCondition);
	}

}
