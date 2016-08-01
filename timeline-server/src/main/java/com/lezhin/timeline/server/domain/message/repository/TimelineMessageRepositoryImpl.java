package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.follow.model.QTimelineFollowEntity;
import com.lezhin.timeline.server.domain.follow.model.TimelineFollowEntity;
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
	public List<TimelineMessageEntity> findAllFollowingTimelineMessages(String timelineLoginId, Long lastTimelineMessageId, Integer size) {
		QTimelineFollowEntity qTimelineFollowEntity = QTimelineFollowEntity.timelineFollowEntity;
		QTimelineMessageEntity qTimelineMessageEntity = QTimelineMessageEntity.timelineMessageEntity;
//		JPQLQuery query = from(qTimelineFollowEntity).where(qTimelineFollowEntity.follower.loginId.eq(timelineLoginId))
//			.innerJoin(qTimelineMessageEntity).on(qTimelineFollowEntity.following.loginId.eq(qTimelineMessageEntity.author.loginId));
//		if (lastTimelineMessageId != null) {
//			query.where(qTimelineMessageEntity.id.lt(lastTimelineMessageId));
//		}
//		query.limit(size);
//		return query.list(qTimelineMessageEntity);

		List<TimelineFollowEntity> follows = from(qTimelineFollowEntity).where(qTimelineFollowEntity.follower.loginId.eq(timelineLoginId))
			.list(qTimelineFollowEntity);
		JPQLQuery query = from(qTimelineMessageEntity).where(qTimelineMessageEntity.author.loginId.in(
			follows.stream()
				.map(follow -> follow.getFollowing().getLoginId())
				.collect(Collectors.toList())));
		if (lastTimelineMessageId != null) {
			query.where(qTimelineMessageEntity.id.lt(lastTimelineMessageId));
		}
		query.orderBy(qTimelineMessageEntity.id.desc()).limit(size);
		return query.list(qTimelineMessageEntity);

//		JPQLQuery query = from(qTimelineFollowEntity, qTimelineMessageEntity)
//			.where(qTimelineFollowEntity.follower.loginId.eq(timelineLoginId)
//				.and(qTimelineFollowEntity.following.loginId.eq(qTimelineMessageEntity.author.loginId)));
//		if (lastTimelineMessageId != null) {
//			query.where(qTimelineMessageEntity.id.lt(lastTimelineMessageId));
//		}
//		query.orderBy(qTimelineMessageEntity.id.desc()).limit(size);
//		return query.list(qTimelineMessageEntity);
	}

}
