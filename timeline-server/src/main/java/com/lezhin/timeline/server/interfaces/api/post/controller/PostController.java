package com.lezhin.timeline.server.interfaces.api.post.controller;

import com.lezhin.timeline.server.domain.post.dto.PostInsertForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{loginId}/post")
public class PostController {

	@RequestMapping(path = "", method = RequestMethod.POST)
	public void post(@PathVariable("loginId") String loginId, @RequestBody PostInsertForm insertForm) {

	}

}
