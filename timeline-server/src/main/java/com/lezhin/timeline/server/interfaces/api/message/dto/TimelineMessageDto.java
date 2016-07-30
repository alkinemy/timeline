package com.lezhin.timeline.server.interfaces.api.message.dto;

import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessageDto {

	private String messageId;
	private TimelineUserDto author;
	private String contents;
	private String parentMessageId;

}
