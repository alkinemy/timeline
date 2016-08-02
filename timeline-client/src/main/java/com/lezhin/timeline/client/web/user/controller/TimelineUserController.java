package com.lezhin.timeline.client.web.user.controller;

import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.message.service.TimelineMessageApiFacadeService;
import com.lezhin.timeline.client.web.user.dto.TimelineUserPageApiParam;
import com.lezhin.timeline.client.web.user.service.TimelineUserApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimelineUserController {

	@Autowired
	private TimelineUserApiFacadeService timelineUserApiFacadeService;
	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = {"", "/newsfeed"}, method = RequestMethod.GET)
	public String newsFeedPage(@AuthenticationPrincipal TimelineUser user, TimelineUserPageApiParam userPageParam, Model model) {
		model.addAttribute("timelineMessages", timelineMessageApiFacadeService.getNewsFeed(user, userPageParam));
		return "user/newsfeed";
	}

	@RequestMapping(path = "/{loginId}", method = RequestMethod.GET)
	public String userPage(@AuthenticationPrincipal TimelineUser user,
							@PathVariable("loginId") String targetUserLoginId,
							TimelineUserPageApiParam userPageParam,
							Model model) {

		model.addAttribute("user", timelineUserApiFacadeService.getUser(targetUserLoginId));
		model.addAttribute("timelineMessages", timelineMessageApiFacadeService.getMessages(targetUserLoginId, userPageParam));
		return "user/user-home";
	}

}
