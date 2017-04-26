package al.timeline.server.domain.message.repository;

import al.timeline.server.domain.message.dto.NewsFeedConditions;
import al.timeline.server.domain.message.model.TimelineMessageEntity;

import java.util.List;

public interface TimelineMessageCustomRepository {

	List<TimelineMessageEntity> findAllFollowingTimelineMessages(NewsFeedConditions conditions);

}
