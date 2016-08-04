package com.lezhin.timeline.server.domain.activity.model;

import com.lezhin.timeline.server.domain.base.entity.AuditEntity;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name = "activity_logs")
public abstract class ActivityLogEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "loginId", column = @Column(name = "from_login_id")),
		@AttributeOverride(name = "name", column = @Column(name = "from_name")),
	})
	private TimelineUser from;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "loginId", column = @Column(name = "to_login_id")),
		@AttributeOverride(name = "name", column = @Column(name = "to_name")),
	})
	private TimelineUser to;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", insertable = false, updatable = false)
	private ActivityType type;

	private LocalDateTime activityDate = LocalDateTime.now();

}
