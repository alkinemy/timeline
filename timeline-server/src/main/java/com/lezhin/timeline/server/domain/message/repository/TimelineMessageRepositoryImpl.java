package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.follow.model.QTimelineFollowEntity;
import com.lezhin.timeline.server.domain.message.model.QTimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class TimelineMessageRepositoryImpl extends QueryDslRepositorySupport implements TimelineMessageCustomRepository {

	public TimelineMessageRepositoryImpl() {
		super(TimelineMessageEntity.class);
	}

	@Override
	public List<TimelineMessageEntity> findAllFollowingTimelineMessages(String timelineLoginId, Long timelineMessageId, Integer size) {
		QTimelineFollowEntity qTimelineFollowEntity = QTimelineFollowEntity.timelineFollowEntity;
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;
		return from(qTimelineFollowEntity).where(qTimelineFollowEntity.follower.loginId.eq(timelineLoginId))
			.innerJoin(qTimelineMessageEntity).on(qTimelineFollowEntity.following.loginId.eq(qTimelineMessageEntity.author.loginId))
			.where(qTimelineMessageEntity.id.lt(timelineMessageId))
			.limit(size)
			.list(qTimelineMessageEntity);
	}

}
