package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;

import java.util.List;

public interface TimelineMessageCustomRepository {

	List<TimelineMessageEntity> findAllFollowingTimelineMessages(String timelineLoginId, Long TimelineMessageId, Integer size);

}
