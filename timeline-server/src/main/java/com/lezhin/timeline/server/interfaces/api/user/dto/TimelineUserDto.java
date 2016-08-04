package com.lezhin.timeline.server.interfaces.api.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class TimelineUserDto {

	@NotBlank
	private String loginId;

	private String name;

}
