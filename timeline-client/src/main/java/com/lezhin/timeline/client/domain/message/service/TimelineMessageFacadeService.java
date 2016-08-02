package com.lezhin.timeline.client.domain.message.service;

import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineMessagePostForm;
import com.lezhin.timeline.client.domain.message.dto.TimelineNewsFeedParam;
import com.lezhin.timeline.client.domain.message.dto.TimelineUserMessageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineMessageFacadeService {

	@Autowired
	private TimelineMessageAdapterService timelineMessageAdapterService;

	public List<TimelineMessageDto> getNewsFeed(TimelineNewsFeedParam newsFeedParam) {
		return timelineMessageAdapterService.getNewsFeed(newsFeedParam);
	}

	public List<TimelineMessageDto> getMessages(TimelineUserMessageParam userMessageParam) {
		return timelineMessageAdapterService.getMessages(userMessageParam);
	}

	public void postMessage(TimelineMessagePostForm postForm) {
		timelineMessageAdapterService.postMessage(postForm);
	}
}
