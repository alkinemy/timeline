package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.follow.model.QTimelineFollowEntity;
import com.lezhin.timeline.server.domain.message.model.QTimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.mysema.query.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class TimelineMessageRepositoryImpl extends QueryDslRepositorySupport implements TimelineMessageCustomRepository {

	public TimelineMessageRepositoryImpl() {
		super(TimelineMessageEntity.class);
	}

	@Override
	public List<TimelineMessageEntity> findAllFollowingTimelineMessages(String timelineLoginId, Long lastTimelineMessageId, Integer size) {
		QTimelineFollowEntity qTimelineFollowEntity = QTimelineFollowEntity.timelineFollowEntity;
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;
		JPQLQuery query = from(qTimelineFollowEntity).where(qTimelineFollowEntity.follower.loginId.eq(timelineLoginId))
			.innerJoin(qTimelineMessageEntity).on(qTimelineFollowEntity.following.loginId.eq(qTimelineMessageEntity.author.loginId));
		if (lastTimelineMessageId != null) {
			query.where(qTimelineMessageEntity.id.lt(lastTimelineMessageId));
		}
		query.limit(size);
		return query.list(qTimelineMessageEntity);
	}

}
