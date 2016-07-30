package com.lezhin.timeline.server.interfaces.api.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityLogDto {

	private TimelineUserDto from;
	private String message;
	private String linkUrl;

}
