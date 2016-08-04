package com.lezhin.timeline.member.domain.user.model;

import com.lezhin.timeline.member.domain.base.entity.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "timeline_users")
public class TimelineUserEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "password_hash")
	private String password;

	@Embedded
	private TimelineUser user;

}
