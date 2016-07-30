package com.lezhin.timeline.server.interfaces.api.follow.controller;

import com.lezhin.timeline.server.interfaces.api.follow.service.FollowingApiFacadeService;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{loginId}/followings")
public class FollowingController {

	@Autowired
	private FollowingApiFacadeService followingApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<TimelineUserDto> getFollowings(@PathVariable("loginId") String loginId) {
		return followingApiFacadeService.getFollowings(loginId);
	}

}
