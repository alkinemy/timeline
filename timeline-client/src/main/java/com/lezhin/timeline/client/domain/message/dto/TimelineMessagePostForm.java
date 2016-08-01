package com.lezhin.timeline.client.domain.message.dto;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessagePostForm {

	private TimelineUserDto user;
	private String contents;
	private String parentMessageId;

}
