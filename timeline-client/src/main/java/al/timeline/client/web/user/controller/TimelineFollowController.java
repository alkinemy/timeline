package al.timeline.client.web.user.controller;

import al.timeline.client.domain.user.model.TimelineUser;
import al.timeline.client.web.user.service.TimelineFollowWebFacadeService;
import al.timeline.client.web.user.service.TimelineUserWebFacadeService;
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
	private TimelineUserWebFacadeService timelineUserWebFacadeService;

	@Autowired
	private TimelineFollowWebFacadeService timelineFollowWebFacadeService;

	@RequestMapping(path = "/{loginId}/follows/following", method = RequestMethod.GET)
	public String showFollowings(@PathVariable("loginId") String loginId, Model model) {
		model.addAttribute("user", timelineUserWebFacadeService.getUser(loginId));
		model.addAttribute("followings", timelineFollowWebFacadeService.getFollowings(loginId));
		return "user/following";
	}

	@RequestMapping(path = "/{loginId}/follows/followers", method = RequestMethod.GET)
	public String showFollowers(@PathVariable("loginId") String loginId, Model model) {
		model.addAttribute("user", timelineUserWebFacadeService.getUser(loginId));
		model.addAttribute("followers", timelineFollowWebFacadeService.getFollowers(loginId));
		return "user/follower";
	}

	@RequestMapping(path = "/{loginId}/follow", method = RequestMethod.POST)
	public String follow(@AuthenticationPrincipal TimelineUser timelineUser, @PathVariable("loginId") String followingLoginId) {
		timelineFollowWebFacadeService.follow(timelineUser, followingLoginId);
		return "redirect:/";
	}

	@RequestMapping(path = "/{loginId}/unfollow", method = RequestMethod.POST)
	public String unfollow(@AuthenticationPrincipal TimelineUser timelineUser, @PathVariable("loginId") String followingLoginId) {
		timelineFollowWebFacadeService.unfollow(timelineUser, followingLoginId);
		return "redirect:/";
	}

}
