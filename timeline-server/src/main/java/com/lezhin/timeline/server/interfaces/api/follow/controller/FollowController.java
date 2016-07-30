package com.lezhin.timeline.server.interfaces.api.follow.controller;

import com.lezhin.timeline.server.interfaces.api.follow.dto.FollowingApiInsertForm;
import com.lezhin.timeline.server.interfaces.api.follow.dto.UnfollowApiForm;
import com.lezhin.timeline.server.interfaces.api.follow.service.FollowApiFacadeService;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{loginId}/followings")
public class FollowController {

	@Autowired
	private FollowApiFacadeService followApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<TimelineUserDto> getFollowings(@PathVariable("loginId") String loginId) {
		return followApiFacadeService.getFollowings(loginId);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void following(@PathVariable("loginId") String loginId, FollowingApiInsertForm insertApiForm) {
		followApiFacadeService.addFollowing(loginId, insertApiForm);
	}

	@RequestMapping(path = "", method = RequestMethod.DELETE)
	public void unfollow(@PathVariable("loginId") String loginId, UnfollowApiForm unfollowApiForm) {
		followApiFacadeService.unfollowing(loginId, unfollowApiForm);
	}

}
