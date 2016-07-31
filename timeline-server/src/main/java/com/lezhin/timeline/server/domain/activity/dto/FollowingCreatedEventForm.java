package com.lezhin.timeline.server.domain.activity.dto;

import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowingCreatedEventForm {

	private TimelineUserDto follower;
	private TimelineUserDto following;

}
