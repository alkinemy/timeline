package com.lezhin.timeline.server.interfaces.api.follow.controller;

import com.lezhin.timeline.server.interfaces.api.follow.dto.FollowingApiInsertForm;
import com.lezhin.timeline.server.interfaces.api.follow.dto.UnfollowApiForm;
import com.lezhin.timeline.server.interfaces.api.follow.service.TimelineFollowApiFacadeService;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/followings")
public class TimelineFollowController {

	@Autowired
	private TimelineFollowApiFacadeService timelineFollowApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		return timelineFollowApiFacadeService.getFollowings(user);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void following(TimelineUserDto user, FollowingApiInsertForm insertApiForm) {
		timelineFollowApiFacadeService.addFollowing(user, insertApiForm);
	}

	@RequestMapping(path = "", method = RequestMethod.DELETE)
	public void unfollow(TimelineUserDto user, UnfollowApiForm unfollowApiForm) {
		timelineFollowApiFacadeService.unfollowing(user, unfollowApiForm);
	}

}
