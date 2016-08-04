package com.lezhin.timeline.client.web.user.controller;

import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.user.service.TimelineUserApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimelineFollowController {

	@Autowired
	private TimelineUserApiFacadeService timelineUserApiFacadeService;

	@RequestMapping(path = "/{loginId}/follows/following", method = RequestMethod.GET)
	public String showFollowings(@PathVariable("loginId") String loginId, Model model) {
		model.addAttribute("user", timelineUserApiFacadeService.getUser(loginId));
		model.addAttribute("followings", timelineUserApiFacadeService.getFollowings(loginId));
		return "user/following";
	}

	@RequestMapping(path = "/{loginId}/follows/followers", method = RequestMethod.GET)
	public String showFollowers(@PathVariable("loginId") String loginId, Model model) {
		model.addAttribute("user", timelineUserApiFacadeService.getUser(loginId));
		model.addAttribute("followers", timelineUserApiFacadeService.getFollowers(loginId));
		return "user/follower";
	}

	@RequestMapping(path = "/{loginId}/follow", method = RequestMethod.POST)
	public String follow(@AuthenticationPrincipal TimelineUser timelineUser, @PathVariable("loginId") String followingLoginId) {
		timelineUserApiFacadeService.follow(timelineUser, followingLoginId);
		return "redirect:/";
	}

	@RequestMapping(path = "/{loginId}/unfollow", method = RequestMethod.POST)
	public String unfollow(@AuthenticationPrincipal TimelineUser timelineUser, @PathVariable("loginId") String followingLoginId) {
		timelineUserApiFacadeService.unfollow(timelineUser, followingLoginId);
		return "redirect:/";
	}

}
