package com.lezhin.timeline.client.web.newsfeed.controller;

import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.newsfeed.dto.NewsFeedApiParam;
import com.lezhin.timeline.client.web.newsfeed.service.NewsFeedApiFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class NewsFeedController {

	@Autowired
	private NewsFeedApiFacadeService newsFeedApiFacadeService;

	@RequestMapping(path = {"", "/newsfeed"}, method = RequestMethod.GET)
	public String newsFeed(@AuthenticationPrincipal TimelineUser user, NewsFeedApiParam param, Model model) {
		log.debug("user(ID: {})", user.getUsername());
		model.addAttribute("userName", user.getName());
		model.addAttribute("timelineMessages", newsFeedApiFacadeService.getNewsFeed(user, param));
		return "newsfeed/newsfeed";
	}

}
