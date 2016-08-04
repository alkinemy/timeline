package com.lezhin.timeline.server.interfaces.api.message.dto;

import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TimelineMessagePostForm {

	@NotNull
	private TimelineUserDto user;

	@NotBlank
	private String contents;

	private String parentMessageId;

}
