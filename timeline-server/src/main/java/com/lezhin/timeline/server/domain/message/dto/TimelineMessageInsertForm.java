package com.lezhin.timeline.server.domain.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessageInsertForm {

	private String loginId;

	private String contents;

	private String parentMessageId;

}
