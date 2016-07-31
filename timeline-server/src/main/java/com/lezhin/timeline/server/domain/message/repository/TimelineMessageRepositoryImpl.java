package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.message.model.QTimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.user.model.QTimelineFollowMappingEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class TimelineMessageRepositoryImpl extends QueryDslRepositorySupport implements TimelineMessageCustomRepository {

	public TimelineMessageRepositoryImpl() {
		super(TimelineMessageEntity.class);
	}

	@Override
	public List<TimelineMessageEntity> findAllFollowingTimelineMessages(String timelineLoginId, Long timelineMessageId, Integer size) {
		QTimelineFollowMappingEntity qTimelineFollowMappingEntity = QTimelineFollowMappingEntity.timelineFollowMappingEntity;
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;
		return from(qTimelineFollowMappingEntity).where(qTimelineFollowMappingEntity.followerLoginId.eq(timelineLoginId))
			.innerJoin(qTimelineMessageEntity).on(qTimelineFollowMappingEntity.followingLoginId.eq(qTimelineMessageEntity.author.loginId))
			.where(qTimelineMessageEntity.id.lt(timelineMessageId))
			.limit(size)
			.list(qTimelineMessageEntity);
	}

}
