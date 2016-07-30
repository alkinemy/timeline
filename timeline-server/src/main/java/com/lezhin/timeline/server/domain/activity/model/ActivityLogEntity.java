package com.lezhin.timeline.server.domain.activity.model;

import com.lezhin.timeline.server.domain.base.entity.AuditEntity;
import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "activity_logs")
public class ActivityLogEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "login_id", column = @Column(name = "from_login_id")),
		@AttributeOverride(name = "name", column = @Column(name = "from_name")),
	})
	private TimelineUser fromUser;

	@Enumerated(EnumType.STRING)
	private ActivityType type;

	private String linkUrl;

}
