package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageSearchConditions;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessagesSearchConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineMessageFacadeService {

	@Autowired
	private TimelineMessageAdapterService timelineMessageAdapterService;

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessagesSearchConditions userMessagesSearchConditions) {
		return timelineMessageAdapterService.getNewsFeed(userMessagesSearchConditions);
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessagesSearchConditions userMessagesSearchConditions) {
		return timelineMessageAdapterService.getMessages(userMessagesSearchConditions);
	}

	public void postMessage(TimelineMessagePostForm postForm) {
		timelineMessageAdapterService.postMessage(postForm);
	}

	public TimelineMessageDto getMessage(TimelineUserMessageSearchConditions userMessageParam) {
		return timelineMessageAdapterService.getMessage(userMessageParam);
	}

}
