package com.lezhin.timeline.server.interfaces.api.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserInsertForm {

	private String loginId;
	private String name;
	private String password;

}
