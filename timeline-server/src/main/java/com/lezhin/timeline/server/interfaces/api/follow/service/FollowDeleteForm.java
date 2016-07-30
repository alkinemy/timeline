package com.lezhin.timeline.server.interfaces.api.follow.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowDeleteForm {

	private String loginId;
	private String followingLoginId;

}
