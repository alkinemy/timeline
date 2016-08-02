package com.lezhin.timeline.client.web.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserPageApiParam {

	private Integer size;
	private String lastTimelineMessageId;

}
