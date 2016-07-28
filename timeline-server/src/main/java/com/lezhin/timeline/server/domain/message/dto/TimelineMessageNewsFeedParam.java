package com.lezhin.timeline.server.domain.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessageNewsFeedParam {

	private String loginId;
	private Integer size;
	private String lastTimelineMessageId;

}
