package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.message.model.QTimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.user.model.QTimelineFollowMapping;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class TimelineMessageRepositoryImpl extends QueryDslRepositorySupport implements TimelineMessageCustomRepository {

	public TimelineMessageRepositoryImpl() {
		super(TimelineMessageEntity.class);
	}

	@Override
	public List<TimelineMessageEntity> findAllFollowingTimelineMessages(String timelineLoginId, Long timelineMessageId, Integer size) {
		QTimelineFollowMapping qTimelineFollowMapping = QTimelineFollowMapping.timelineFollowMapping;
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;
		return from(qTimelineFollowMapping).where(qTimelineFollowMapping.followerLoginId.eq(timelineLoginId))
			.innerJoin(qTimelineMessageEntity).on(qTimelineFollowMapping.followingLoginId.eq(qTimelineMessageEntity.author.loginId))
			.where(qTimelineMessageEntity.id.lt(timelineMessageId))
			.limit(size)
			.list(qTimelineMessageEntity);
	}

}
