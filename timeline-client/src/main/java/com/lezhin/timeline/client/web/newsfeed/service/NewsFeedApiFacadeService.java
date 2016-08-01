package com.lezhin.timeline.client.web.newsfeed.service;

import com.lezhin.timeline.client.domain.message.dto.TimelineMessageDto;
import com.lezhin.timeline.client.domain.message.dto.TimelineNewsFeedParam;
import com.lezhin.timeline.client.domain.message.service.TimelineMessageFacadeService;
import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.newsfeed.dto.NewsFeedApiParam;
import com.lezhin.timeline.common.domain.base.assembler.SmartAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedApiFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public List<TimelineMessageDto> getNewsFeed(TimelineUser user, NewsFeedApiParam param) {
		TimelineNewsFeedParam newsFeedParam = assembler.assemble(param, TimelineNewsFeedParam.class);
		newsFeedParam.setLoginId(user.getUsername());
		return timelineMessageFacadeService.getNewsFeed(newsFeedParam);
	}

}
