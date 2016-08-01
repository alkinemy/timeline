package com.lezhin.timeline.client.web.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessagePostApiForm {

	private String contents;
	private String parentMessageId;

}
