package com.lezhin.timeline.server.domain.follow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineFollowDeleteForm {

	private String followerLoginId;
	private String followingLoginId;

}
