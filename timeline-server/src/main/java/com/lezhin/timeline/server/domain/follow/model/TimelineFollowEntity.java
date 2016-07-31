package com.lezhin.timeline.server.domain.follow.model;

import com.lezhin.timeline.server.domain.base.entity.AuditEntity;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "timeline_follows")
public class TimelineFollowEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "login_id", column = @Column(name = "follower_login_id")),
		@AttributeOverride(name = "name", column = @Column(name = "follower_name")),
	})
	private TimelineUser follower;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "login_id", column = @Column(name = "following_login_id")),
		@AttributeOverride(name = "name", column = @Column(name = "following_name")),
	})
	private TimelineUser following;

}
