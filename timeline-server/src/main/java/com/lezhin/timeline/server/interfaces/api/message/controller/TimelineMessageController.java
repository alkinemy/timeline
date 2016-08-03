package com.lezhin.timeline.server.interfaces.api.message.controller;

import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageInsertApiForm;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineUserMessageApiConditions;
import com.lezhin.timeline.server.interfaces.api.message.service.TimelineMessageApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TimelineMessageController {

	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = "/messages", method = RequestMethod.POST)
	public void post(@RequestBody TimelineMessageInsertApiForm insertApiForm) {
		timelineMessageApiFacadeService.postMessage(insertApiForm);
	}

	@RequestMapping(path = "/messages", method = RequestMethod.GET)
	public List<TimelineMessageDto> list(TimelineUserMessageApiConditions userMessageConditions) {
		return timelineMessageApiFacadeService.listMessages(userMessageConditions);
	}

	@RequestMapping(path = "/{loginId}/messages/{messageId}", method = RequestMethod.GET)
	public TimelineMessageDto get(@PathVariable("loginId") String loginId, @PathVariable("messageId") String messageId) {
		return timelineMessageApiFacadeService.getMessage(loginId, messageId);
	}

	@RequestMapping(path = "/newsfeed", method = RequestMethod.GET)
	public List<TimelineMessageDto> getNewsFeed(TimelineUserMessageApiConditions userMessageConditions) {
		return timelineMessageApiFacadeService.getNewsFeed(userMessageConditions);
	}

}
