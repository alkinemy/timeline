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
public class TimelineUser extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String loginId;

	private String userName;


	@ManyToMany
	@JoinTable(name = "timeline_users",
		joinColumns = @JoinColumn(name = "follower_user_id"), inverseJoinColumns = @JoinColumn(name = "following_user_id"))
	private List<TimelineUser> followings = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "timeline_users",
		joinColumns = @JoinColumn(name = "following_user_id"), inverseJoinColumns = @JoinColumn(name = "follower_user_id"))
	private List<TimelineUser> followers = new ArrayList<>();

}
