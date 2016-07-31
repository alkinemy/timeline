package com.lezhin.timeline.member.interfaces.api.user.controller;

import com.lezhin.timeline.member.interfaces.api.user.dto.TimelineUserDto;
import com.lezhin.timeline.member.interfaces.api.user.dto.TimelineUserInsertForm;
import com.lezhin.timeline.member.interfaces.api.user.service.TimelineUserApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{loginId}")
public class TimelineUserController {

	@Autowired
	private TimelineUserApiFacadeService timelineUserApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public TimelineUserDto getTimelineUser(@PathVariable String loginId) {
		return timelineUserApiFacadeService.getTimelineUser(loginId);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void register(@RequestBody TimelineUserInsertForm insertForm) {
		timelineUserApiFacadeService.register(insertForm);
	}

}
