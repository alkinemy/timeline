package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.message.dto.TimelineMessageNewsFeedParam;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.domain.user.service.TimelineUserFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsFeedFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	public List<TimelineMessageEntity> getNewsFeed(TimelineMessageNewsFeedParam newsFeedParam) {
		TimelineUserEntity timelineUser = timelineUserFacadeService.getTimelineUser(newsFeedParam.getLoginId());
		TimelineMessageEntity timelineMessage = timelineMessageFacadeService.getTimelineMessage(newsFeedParam.getLastTimelineMessageId());
		return timelineMessageFacadeService.getFollowingTimelineMessages(timelineUser, timelineMessage, newsFeedParam.getSize());
	}

}
