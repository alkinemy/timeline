package com.lezhin.timeline.client.domain.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserMessagesParam {

	private String loginId;
	private Integer size;
	private String lastTimelineMessageId;

}
