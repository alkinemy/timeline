package com.lezhin.timeline.server.interfaces.api.follow.controller;

import com.lezhin.timeline.server.interfaces.api.follow.dto.FollowDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{loginId}/followings")
public class FollowingController {

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<FollowDto> getFollowings(@PathVariable("loginId") String loginId) {
		return null;
	}

}
