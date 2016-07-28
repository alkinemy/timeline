package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.repository.TimelineMessageRepository;
import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimelineMessageQueryService {

	@Autowired
	private TimelineMessageRepository timelineMessageRepository;

	public List<TimelineMessageEntity> findAll(TimelineUser user) {
		return timelineMessageRepository.findAllByAuthorLoginId(user.getLoginId());
	}

	public Optional<TimelineMessageEntity>findOne(String messageId) {
		return timelineMessageRepository.findOneByMessageId(messageId);
	}

	public List<TimelineMessageEntity> findFollowingTimelineMessages(TimelineUserEntity timelineUser, TimelineMessageEntity timelineMessage, Integer size) {
		return timelineMessageRepository.findAllFollowingTimelineMessages(timelineUser.getUser().getLoginId(), timelineMessage.getId(), size);
	}

}
