package com.lezhin.timeline.server.interfaces.api.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessageInsertApiForm {

	private String contents;
	private String parentMessageId;

}
