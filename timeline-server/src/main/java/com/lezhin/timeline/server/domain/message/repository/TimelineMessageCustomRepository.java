package com.lezhin.timeline.server.domain.message.repository;

import com.lezhin.timeline.server.domain.message.dto.NewsFeedConditions;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;

import java.util.List;

public interface TimelineMessageCustomRepository {

	List<TimelineMessageEntity> findAllFollowingTimelineMessages(NewsFeedConditions conditions);

}
