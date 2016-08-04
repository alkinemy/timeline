package com.lezhin.timeline.server.interfaces.api.follow.controller;

import com.lezhin.timeline.server.domain.follow.dto.TimelineFollowDeleteForm;
import com.lezhin.timeline.server.domain.follow.dto.TimelineFollowInsertForm;
import com.lezhin.timeline.server.interfaces.api.follow.service.TimelineFollowApiFacadeService;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/follows")
public class TimelineFollowController {

	@Autowired
	private TimelineFollowApiFacadeService timelineFollowApiFacadeService;

	@RequestMapping(path = "/followings", method = RequestMethod.GET)
	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		return timelineFollowApiFacadeService.getFollowings(user);
	}

	@RequestMapping(path = "/followers", method = RequestMethod.GET)
	public List<TimelineUserDto> getFollowers(TimelineUserDto user) {
		return timelineFollowApiFacadeService.getFollowers(user);
	}

	@RequestMapping(path = "/follow", method = RequestMethod.POST)
	public void following(@RequestBody TimelineFollowInsertForm insertForm) {
		timelineFollowApiFacadeService.follow(insertForm);
	}

	@RequestMapping(path = "/unfollow", method = RequestMethod.POST)
	public void unfollow(@RequestBody TimelineFollowDeleteForm deleteForm) {
		timelineFollowApiFacadeService.unfollow(deleteForm);
	}

}
