package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.message.dto.TimelineMessageNewsFeedCondition;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	public List<TimelineMessageEntity> getNewsFeed(String loginId, String lastTimelineMessageId, Integer size) {
		TimelineMessageEntity timelineMessage = timelineMessageFacadeService.getTimelineMessage(lastTimelineMessageId);
		TimelineMessageNewsFeedCondition condition = new TimelineMessageNewsFeedCondition();
		condition.setLoginId(loginId);
		condition.setLastTimelineMessageId(timelineMessage.getId());
		condition.setSize(size);
		return timelineMessageFacadeService.getFollowingTimelineMessages(condition);
	}

}
