package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageConditions;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessagesConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineMessageFacadeService {

	@Autowired
	private TimelineMessageAdapterService timelineMessageAdapterService;

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessagesConditions userMessageParam) {
		return timelineMessageAdapterService.getNewsFeed(userMessageParam);
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessagesConditions userMessageParam) {
		return timelineMessageAdapterService.getMessages(userMessageParam);
	}

	public void postMessage(TimelineMessagePostForm postForm) {
		timelineMessageAdapterService.postMessage(postForm);
	}

	public TimelineMessageDto getMessage(TimelineUserMessageConditions userMessageParam) {
		//TODO null처리 필요
		return timelineMessageAdapterService.getMessage(userMessageParam);
	}
}
