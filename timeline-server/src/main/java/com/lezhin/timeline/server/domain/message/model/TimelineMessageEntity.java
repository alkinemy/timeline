package com.lezhin.timeline.server.domain.message.model;

import com.lezhin.timeline.server.domain.base.entity.AuditEntity;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "timeline_messages")
public class TimelineMessageEntity extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String messageId;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "login_id", column = @Column(name = "author_login_id")),
		@AttributeOverride(name = "name", column = @Column(name = "author_name")),
	})
	private TimelineUser author;

	private String contents;

	private String parentMessageId;

}
