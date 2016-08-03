package com.lezhin.timeline.client.web.message.controller;

import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.web.message.dto.TimelineMessagePostApiForm;
import com.lezhin.timeline.client.web.message.service.TimelineMessageApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/message")
public class TimelineMessageController {

	@Autowired
	private TimelineMessageApiFacadeService timelineMessageApiFacadeService;

	@RequestMapping(path = "", method = RequestMethod.POST)
	public String postMessage(@AuthenticationPrincipal TimelineUser user, TimelineMessagePostApiForm postForm) {
		timelineMessageApiFacadeService.postMessage(user, postForm);
		return "redirect:/";
	}

}
