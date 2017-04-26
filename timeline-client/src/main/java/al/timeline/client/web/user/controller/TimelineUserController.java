package al.timeline.client.web.user.controller;

import al.timeline.client.domain.user.model.TimelineUser;
import al.timeline.client.web.base.response.PagedResources;
import al.timeline.client.web.message.service.TimelineMessageWebFacadeService;
import al.timeline.client.web.user.service.TimelineUserWebFacadeService;
import al.timeline.client.web.message.dto.TimelineMessageDtos;
import al.timeline.client.web.user.dto.ActivityLogSearchParam;
import al.timeline.client.web.user.dto.ActivityLogViewDto;
import al.timeline.client.web.message.dto.TimelineUserMessagesSearchParam;
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
	private TimelineUserWebFacadeService timelineUserWebFacadeService;
	@Autowired
	private TimelineMessageWebFacadeService timelineMessageWebFacadeService;

	@RequestMapping(path = {"", "/newsfeed"}, method = RequestMethod.GET)
	public String newsFeedPage(
		@AuthenticationPrincipal TimelineUser user,
		TimelineUserMessagesSearchParam userPageParam,
		ActivityLogSearchParam searchParam,
		Model model) {

		model.addAttribute("timelineMessages", timelineMessageWebFacadeService.getNewsFeed(user, userPageParam));
		model.addAttribute("activityLogs", timelineUserWebFacadeService.getActivityLogs(user, searchParam));
		return "user/newsfeed";
	}

	@RequestMapping(path = "/newsfeed/load", method = RequestMethod.GET)
	@ResponseBody
	public TimelineMessageDtos loadNewsFeed(@AuthenticationPrincipal TimelineUser user, TimelineUserMessagesSearchParam userPageParam) {
		return timelineMessageWebFacadeService.getNewsFeed(user, userPageParam);
	}

	@RequestMapping(path = "/activities/load", method = RequestMethod.GET)
	@ResponseBody
	public PagedResources<ActivityLogViewDto> loadActivities(@AuthenticationPrincipal TimelineUser user, ActivityLogSearchParam searchParam) {
		return timelineUserWebFacadeService.getActivityLogs(user, searchParam);
	}

	@RequestMapping(path = "/{loginId}", method = RequestMethod.GET)
	public String userPage(@PathVariable("loginId") String targetUserLoginId,
							TimelineUserMessagesSearchParam userPageParam,
							Model model) {

		model.addAttribute("user", timelineUserWebFacadeService.getUser(targetUserLoginId));
		model.addAttribute("timelineMessages", timelineMessageWebFacadeService.getMessages(targetUserLoginId, userPageParam));
		return "user/user-home";
	}

	@RequestMapping(path = "/{loginId}/messages/load", method = RequestMethod.GET)
	@ResponseBody
	public TimelineMessageDtos loadUserMessages(@PathVariable("loginId") String targetUserLoginId, TimelineUserMessagesSearchParam userPageParam) {
		return timelineMessageWebFacadeService.getMessages(targetUserLoginId, userPageParam);
	}

}
