package com.lezhin.timeline.server.interfaces.api.newsfeed.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineNewsFeedParam {

	private String loginId;
	private Integer size = 10;
	private String lastTimelineMessageId;

}
