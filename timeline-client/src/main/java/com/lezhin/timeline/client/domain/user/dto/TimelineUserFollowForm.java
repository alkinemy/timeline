package com.lezhin.timeline.client.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserFollowForm {

	private TimelineUserDto follower;
	private TimelineUserDto following;

}
