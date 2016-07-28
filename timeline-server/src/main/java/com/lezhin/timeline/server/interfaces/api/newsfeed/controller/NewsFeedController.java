package com.lezhin.timeline.server.interfaces.api.newsfeed.controller;

import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageNewsFeedParam;
import com.lezhin.timeline.server.interfaces.api.newsfeed.service.NewsFeedApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class NewsFeedController {

	@Autowired
	private NewsFeedApiFacadeService newsFeedApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<TimelineMessageDto> getNewsFeed(TimelineMessageNewsFeedParam newsFeedParam) {
		//TODO PagedResource?
		return newsFeedApiFacadeService.getNewsFeed(newsFeedParam);
	}

}
