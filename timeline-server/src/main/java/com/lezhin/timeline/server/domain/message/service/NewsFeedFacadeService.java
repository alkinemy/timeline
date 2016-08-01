package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.message.dto.TimelineMessageNewsFeedCondition;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	public List<TimelineMessageEntity> getNewsFeed(String loginId, String lastTimelineMessageId, Integer size) {
		TimelineMessageNewsFeedCondition condition = new TimelineMessageNewsFeedCondition();
		condition.setLoginId(loginId);
		condition.setSize(size);
		if (StringUtils.isNotBlank(lastTimelineMessageId)) {
			TimelineMessageEntity timelineMessage = timelineMessageFacadeService.getTimelineMessage(lastTimelineMessageId);
			condition.setLastTimelineMessageId(timelineMessage.getId());
		}
		return timelineMessageFacadeService.getFollowingTimelineMessages(condition);
	}

}
