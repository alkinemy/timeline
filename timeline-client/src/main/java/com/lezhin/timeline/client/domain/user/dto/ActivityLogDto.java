package com.lezhin.timeline.client.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ActivityLogDto {

	private TimelineUserDto from;
	private String message;
	private String linkUrl;
	private LocalDateTime createdDate;

}
