package com.lezhin.timeline.server.interfaces.api.message.controller;

import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageDto;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageInsertApiForm;
import com.lezhin.timeline.server.interfaces.api.message.service.TimelineMessageApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{loginId}/message")
public class TimelineMessageController {

	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void post(@PathVariable("loginId") String loginId, @RequestBody TimelineMessageInsertApiForm insertApiForm) {
		//TODO 인증 정보 확인 필요
		timelineMessageApiFacadeService.postMessage(loginId, insertApiForm);
	}

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<TimelineMessageDto> list(@PathVariable("loginId") String loginId) {
		return timelineMessageApiFacadeService.listMessages(loginId);
	}

}
