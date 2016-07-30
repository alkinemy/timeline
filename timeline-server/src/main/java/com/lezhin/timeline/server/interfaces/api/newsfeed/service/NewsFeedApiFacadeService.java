package com.lezhin.timeline.server.interfaces.api.newsfeed.service;

import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.service.NewsFeedFacadeService;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.interfaces.api.newsfeed.dto.TimelineNewsFeedParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedApiFacadeService {

	@Autowired
	private NewsFeedFacadeService newsFeedFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public List<TimelineMessageDto> getNewsFeed(TimelineNewsFeedParam newsFeedParam) {
		List<TimelineMessageEntity> timelineMessages = newsFeedFacadeService.getNewsFeed(
			newsFeedParam.getLoginId(), newsFeedParam.getLastTimelineMessageId(), newsFeedParam.getSize());
		return assembler.assemble(timelineMessages, TimelineMessageDto.class);
	}

}