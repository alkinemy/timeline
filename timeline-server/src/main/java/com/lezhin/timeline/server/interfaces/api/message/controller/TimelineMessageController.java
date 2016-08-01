package com.lezhin.timeline.server.interfaces.api.message.controller;

import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageInsertApiForm;
import com.lezhin.timeline.server.interfaces.api.message.service.TimelineMessageApiFacadeService;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class TimelineMessageController {

	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void post(@RequestBody TimelineMessageInsertApiForm insertApiForm) {
		timelineMessageApiFacadeService.postMessage(insertApiForm);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<TimelineMessageDto> list(TimelineUserDto user) {
		return timelineMessageApiFacadeService.listMessages(user);
	}

}
