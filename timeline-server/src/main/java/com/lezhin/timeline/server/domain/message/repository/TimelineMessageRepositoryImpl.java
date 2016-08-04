package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.follow.model.QTimelineFollowEntity;
import com.lezhin.timeline.server.domain.follow.model.TimelineFollowEntity;
import com.lezhin.timeline.server.domain.message.dto.NewsFeedConditions;
import com.lezhin.timeline.server.domain.message.model.QTimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.mysema.query.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

public class TimelineMessageRepositoryImpl extends QueryDslRepositorySupport implements TimelineMessageCustomRepository {

	public TimelineMessageRepositoryImpl() {
		super(TimelineMessageEntity.class);
	}

	@Override
	public List<TimelineMessageEntity> findAllFollowingTimelineMessages(NewsFeedConditions conditions) {
		QTimelineFollowEntity qTimelineFollowEntity = QTimelineFollowEntity.timelineFollowEntity;
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;

		List<TimelineFollowEntity> follows = from(qTimelineFollowEntity).where(qTimelineFollowEntity.follower.loginId.eq(conditions.getLoginId()))
			.list(qTimelineFollowEntity);
		JPQLQuery query = from(qTimelineMessageEntity).where(qTimelineMessageEntity.author.loginId.in(
			follows.stream()
				.map(follow -> follow.getFollowing().getLoginId())
				.collect(Collectors.toList())));
		if (conditions.getLastTimelineMessageId() != null) {
			query.where(qTimelineMessageEntity.id.lt(conditions.getLastTimelineMessageId()));
		}
		query.orderBy(qTimelineMessageEntity.id.desc()).limit(conditions.getSize());
		return query.list(qTimelineMessageEntity);
	}

}
