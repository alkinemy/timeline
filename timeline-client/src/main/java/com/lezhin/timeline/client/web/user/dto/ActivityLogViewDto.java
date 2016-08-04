package com.lezhin.timeline.client.web.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ActivityLogViewDto {

	private String message;
	private String linkUrl;
	private LocalDateTime activityDate;

}
