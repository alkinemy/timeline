package com.lezhin.timeline.server.domain.user.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowId implements Serializable {

	private String followerLoginId;
	private String followingLoginId;

}
