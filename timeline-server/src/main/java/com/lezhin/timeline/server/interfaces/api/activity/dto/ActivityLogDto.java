package com.lezhin.timeline.server.interfaces.api.activity.dto;

import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityLogDto {

	private TimelineUserDto from;
	private String message;
	private String linkUrl;

}
