package com.lezhin.timeline.client.web.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserMessagesParam {

	private Integer size;
	private String lastTimelineMessageId;

}
