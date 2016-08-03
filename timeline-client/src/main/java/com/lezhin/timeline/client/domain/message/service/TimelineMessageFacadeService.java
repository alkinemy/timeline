package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageParam;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessagesParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineMessageFacadeService {

	@Autowired
	private TimelineMessageAdapterService timelineMessageAdapterService;

	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessagesParam userMessageParam) {
		return timelineMessageAdapterService.getNewsFeed(userMessageParam);
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessagesParam userMessageParam) {
		return timelineMessageAdapterService.getMessages(userMessageParam);
	}

	public void postMessage(TimelineMessagePostForm postForm) {
		timelineMessageAdapterService.postMessage(postForm);
	}

	public TimelineMessageDto getMessage(TimelineUserMessageParam userMessageParam) {
		//TODO null처리 필요
		return timelineMessageAdapterService.getMessage(userMessageParam);
	}
}
