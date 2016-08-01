package com.lezhin.timeline.client.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserInsertForm {

	private String loginId;
	private String name;
	private String password;

}
