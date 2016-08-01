package com.lezhin.timeline.server.interfaces.api.follow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnfollowApiForm {

	private String followerLoginId;
	private String followingLoginId;

}
