package com.lezhin.timeline.client.web.message.service;

import com.google.common.collect.Iterables;
import com.lezhin.timeline.client.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageConditions;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessagesConditions;
import com.lezhin.timeline.client.domain.message.service.TimelineMessageFacadeService;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.message.dto.TimelineMessageDtos;
import com.lezhin.timeline.client.web.message.dto.TimelineMessagePostApiForm;
import com.lezhin.timeline.client.web.message.dto.TimelineUserMessagesParam;
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

	public void postMessage(TimelineUser user, TimelineMessagePostApiForm postApiForm) {
		TimelineMessagePostForm postForm = assembler.assemble(postApiForm, TimelineMessagePostForm.class);
		postForm.setUser(assembler.assemble(user, TimelineUserDto.class));
		timelineMessageFacadeService.postMessage(postForm);
	}

	public TimelineMessageDtos getNewsFeed(TimelineUser user, TimelineUserMessagesParam userPageParam) {
		return getMessages(user.getLoginId(), userPageParam, userMessageParam -> timelineMessageFacadeService.getNewsFeed(userMessageParam));
	}

	public TimelineMessageDtos getMessages(String targetUserLoginId, TimelineUserMessagesParam userPageParam) {
		return getMessages(targetUserLoginId, userPageParam, userMessageParam -> timelineMessageFacadeService.getMessages(userMessageParam));
	}

	private TimelineMessageDtos getMessages(
		String loginId, TimelineUserMessagesParam userPageParam,
		Function<TimelineUserMessagesConditions, List<TimelineMessageDto>> messageSearchFunction) {

		TimelineUserMessagesConditions userMessagesParam = assembler.assemble(userPageParam, TimelineUserMessagesConditions.class);
		userMessagesParam.setLoginId(loginId);
		List<TimelineMessageDto> messages = messageSearchFunction.apply(userMessagesParam);
		TimelineMessageDtos timelineMessageDtos = new TimelineMessageDtos();
		timelineMessageDtos.setMessages(messages);
		if (!messages.isEmpty()) {
			timelineMessageDtos.setLastTimelineMessageId(Iterables.getLast(messages).getMessageId());
		}
		return timelineMessageDtos;
	}

	public TimelineMessageDto getMessage(String loginId, String messageId) {
		TimelineUserMessageConditions userMessageParam = TimelineUserMessageConditions.of(loginId, messageId);
		return timelineMessageFacadeService.getMessage(userMessageParam);
	}

}
