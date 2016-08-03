package com.lezhin.timeline.server.domain.message.dto;

import com.lezhin.timeline.server.domain.base.repository.ExternalSearchConditions;
import com.lezhin.timeline.server.domain.message.model.QTimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineUserMessagesSearchContext;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class TimelineUserMessagesSearchConditions implements ExternalSearchConditions<TimelineUserMessagesSearchContext> {

	private String loginId;
	private Integer size;
	private String lastTimelineMessageId;

	@Override
	public Predicate toPredicate(TimelineUserMessagesSearchContext context) {
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(qTimelineMessageEntity.author.loginId.eq(loginId));
		if (StringUtils.isNotBlank(lastTimelineMessageId)) {
			TimelineMessageEntity lastTimelineMessageEntity = context.getTimelineMessageFacadeService().getTimelineMessage(lastTimelineMessageId);
			booleanBuilder.and(qTimelineMessageEntity.id.lt(lastTimelineMessageEntity.getId()));
		}
		return booleanBuilder;
	}

}
