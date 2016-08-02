package com.lezhin.timeline.server.interfaces.api.follow.controller;

import com.lezhin.timeline.server.interfaces.api.follow.dto.FollowingApiInsertForm;
import com.lezhin.timeline.server.interfaces.api.follow.dto.UnfollowApiForm;
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

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		return timelineFollowApiFacadeService.getFollowings(user);
	}

	@RequestMapping(path = "/follow", method = RequestMethod.POST)
	public void following(@RequestBody FollowingApiInsertForm insertApiForm) {
		timelineFollowApiFacadeService.addFollowing(insertApiForm);
	}

	@RequestMapping(path = "/unfollow", method = RequestMethod.POST)
	public void unfollow(@RequestBody UnfollowApiForm unfollowApiForm) {
		timelineFollowApiFacadeService.unfollowing(unfollowApiForm);
	}

}
