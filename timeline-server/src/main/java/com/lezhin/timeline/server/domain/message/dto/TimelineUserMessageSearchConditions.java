package com.lezhin.timeline.server.domain.message.dto;

import com.lezhin.timeline.server.domain.base.repository.SearchConditions;
import com.lezhin.timeline.server.domain.message.model.QTimelineMessageEntity;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TimelineUserMessageSearchConditions implements SearchConditions {

	private String loginId;
	private String messageId;

	@Override
	public Predicate toPredicate() {
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(qTimelineMessageEntity.messageId.eq(messageId))
			.and(qTimelineMessageEntity.author.loginId.eq(loginId));
		return booleanBuilder;
	}

}
