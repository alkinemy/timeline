package com.lezhin.timeline.server.interfaces.api.newsfeed.controller;

import com.lezhin.timeline.server.interfaces.api.newsfeed.dto.NewsFeedDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class NewsFeedController {

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<NewsFeedDto> getNewsFeed(Pageable pageable) {
		//TODO PagedResource?
		return null;
	}

}
