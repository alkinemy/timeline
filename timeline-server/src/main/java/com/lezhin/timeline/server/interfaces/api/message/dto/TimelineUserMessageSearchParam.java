package com.lezhin.timeline.server.interfaces.api.message.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class TimelineUserMessageSearchParam {

	@NotBlank
	private String loginId;

	private Integer size = 10;
	private String lastTimelineMessageId;

}
