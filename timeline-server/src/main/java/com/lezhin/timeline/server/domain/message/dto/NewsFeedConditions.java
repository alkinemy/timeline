package com.lezhin.timeline.server.domain.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsFeedConditions {

	private String loginId;
	private Long lastTimelineMessageId;
	private Integer size;

}
