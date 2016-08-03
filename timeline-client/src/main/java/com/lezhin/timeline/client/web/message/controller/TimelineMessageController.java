package com.lezhin.timeline.client.web.message.controller;

import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.message.dto.TimelineMessagePostApiForm;
import com.lezhin.timeline.client.web.message.service.TimelineMessageApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimelineMessageController {

	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = "/message", method = RequestMethod.POST)
	public String postMessage(@AuthenticationPrincipal TimelineUser user, TimelineMessagePostApiForm postForm) {
		timelineMessageApiFacadeService.postMessage(user, postForm);
		return "redirect:/";
	}

	@RequestMapping(path = "/{loginId}/messages/{messageId}", method = RequestMethod.GET)
	public String getMessage(@PathVariable("loginId") String loginId, @PathVariable("messageId") String messageId, Model model) {
		model.addAttribute("message", timelineMessageApiFacadeService.getMessage(loginId, messageId));
		return "message/message-page";
	}

}
