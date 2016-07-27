package com.lezhin.timeline.server.interfaces.api.message.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimelineMessageDto {

	private String messageId;
	private String authorLoginId;
	private String authorName;
	private String contents;

	private List<TimelineMessageDto> childMessages;

}
