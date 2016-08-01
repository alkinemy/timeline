package com.lezhin.timeline.client.web.newsfeed.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsFeedApiParam {

	private Integer size;
	private String lastTimelineMessageId;

}
