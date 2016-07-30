package com.lezhin.timeline.server.interfaces.api.follow.controller;

import com.lezhin.timeline.server.interfaces.api.follow.dto.FollowDto;
import com.lezhin.timeline.server.domain.user.service.FollowingFacadeService;
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
	private FollowingFacadeService followingFacadeService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<FollowDto> getFollowings(@PathVariable("loginId") String loginId) {
		return null;
	}

}
