package com.lezhin.timeline.server.domain.post.model;

import com.lezhin.timeline.server.domain.base.entity.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "timeline_posts")
public class Post extends AuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long userId;

	private String contents;

	private Long parentId;

}
