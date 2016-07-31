package com.lezhin.timeline.server.domain.follow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowingInsertForm {

	private String loginId;
	private String followingLoginId;

}
