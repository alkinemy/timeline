package com.lezhin.timeline.server.domain.follow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "timeline_follow_mappings")
@IdClass(FollowId.class)
public class TimelineFollowMappingEntity {

	@Id
	@Column(name = "follower_login_id")
	private String followerLoginId;

	@Id
	@Column(name = "following_login_id")
	private String followingLoginId;

}
