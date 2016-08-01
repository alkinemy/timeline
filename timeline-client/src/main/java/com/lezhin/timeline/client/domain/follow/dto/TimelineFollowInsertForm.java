package com.lezhin.timeline.client.domain.follow.dto;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineFollowInsertForm {

	private TimelineUserDto follower;
	private TimelineUserDto following;

}
