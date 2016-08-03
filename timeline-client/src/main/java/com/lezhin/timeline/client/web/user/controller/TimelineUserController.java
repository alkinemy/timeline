package com.lezhin.timeline.client.web.user.controller;

import com.lezhin.timeline.client.domain.user.dto.ActivityLogDto;
import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.base.response.PagedResources;
import com.lezhin.timeline.client.web.message.dto.TimelineMessageDtos;
import com.lezhin.timeline.client.web.message.service.TimelineMessageApiFacadeService;
import com.lezhin.timeline.client.web.user.dto.ActivityLogSearchParam;
import com.lezhin.timeline.client.web.user.dto.TimelineUserPageApiParam;
import com.lezhin.timeline.client.web.user.service.TimelineUserApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimelineUserController {

	@Autowired
	private TimelineUserApiFacadeService timelineUserApiFacadeService;
	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = {"", "/newsfeed"}, method = RequestMethod.GET)
	public String newsFeedPage(
		@AuthenticationPrincipal TimelineUser user,
		TimelineUserPageApiParam userPageParam,
		ActivityLogSearchParam searchParam,
		Model model) {

		model.addAttribute("timelineMessages", timelineMessageApiFacadeService.getNewsFeed(user, userPageParam));
		model.addAttribute("activityLogs", timelineUserApiFacadeService.getActivityLogs(user, searchParam));
		return "user/newsfeed";
	}

	@RequestMapping(path = "/newsfeed/load", method = RequestMethod.GET)
	@ResponseBody
	public TimelineMessageDtos loadNewsFeed(@AuthenticationPrincipal TimelineUser user, TimelineUserPageApiParam userPageParam) {
		return timelineMessageApiFacadeService.getNewsFeed(user, userPageParam);
	}

	@RequestMapping(path = "/activities/load", method = RequestMethod.GET)
	@ResponseBody
	public PagedResources<ActivityLogDto> loadActivities(@AuthenticationPrincipal TimelineUser user, ActivityLogSearchParam searchParam) {
		return timelineUserApiFacadeService.getActivityLogs(user, searchParam);
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

	@RequestMapping(path = "/{loginId}/messages/load", method = RequestMethod.GET)
	@ResponseBody
	public TimelineMessageDtos loadUserMessages(@PathVariable("loginId") String targetUserLoginId, TimelineUserPageApiParam userPageParam) {
		return timelineMessageApiFacadeService.getMessages(targetUserLoginId, userPageParam);
	}

}
