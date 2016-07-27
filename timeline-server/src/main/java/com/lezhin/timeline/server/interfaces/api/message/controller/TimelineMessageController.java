package com.lezhin.timeline.server.interfaces.api.message.controller;

import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageInsertApiForm;
import com.lezhin.timeline.server.interfaces.api.message.service.TimelineMessageApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{loginId}/post")
public class TimelineMessageController {

	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void post(@PathVariable("loginId") String loginId, @RequestBody TimelineMessageInsertApiForm insertApiForm) {
		//TODO 인증 정보 확인 필요
		timelineMessageApiFacadeService.post(loginId, insertApiForm);
	}

}
