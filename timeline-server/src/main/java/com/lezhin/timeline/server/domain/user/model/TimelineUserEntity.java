package com.lezhin.timeline.server.domain.user.model;

import com.lezhin.timeline.server.domain.base.entity.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "timeline_users")
public class TimelineUserEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private TimelineUser user;


	//TODO 나는 나를 팔로우하는걸로 처리
	@ManyToMany
	@JoinTable(name = "timeline_users",
		joinColumns = @JoinColumn(name = "follower_login_id"), inverseJoinColumns = @JoinColumn(name = "following_login_id"))
	private List<TimelineUserEntity> followings = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "timeline_users",
		joinColumns = @JoinColumn(name = "following_login_id"), inverseJoinColumns = @JoinColumn(name = "follower_login_id"))
	private List<TimelineUserEntity> followers = new ArrayList<>();

}
