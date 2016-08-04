package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.message.dto.NewsFeedConditions;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.repository.TimelineMessageRepository;
import com.mysema.query.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimelineMessageQueryService {

	@Autowired
	private TimelineMessageRepository timelineMessageRepository;

	public Optional<TimelineMessageEntity> findOne(String messageId) {
		return timelineMessageRepository.findOneByMessageId(messageId);
	}

	public Optional<TimelineMessageEntity> findOne(Predicate predicate) {
		return Optional.ofNullable(timelineMessageRepository.findOne(predicate));
	}

	public List<TimelineMessageEntity> findAllFollowingMessages(NewsFeedConditions conditions) {
		return timelineMessageRepository.findAllFollowingTimelineMessages(conditions);
	}

	public List<TimelineMessageEntity> findAll(Predicate predicate, Pageable pageable) {
		return timelineMessageRepository.findAll(predicate, pageable).getContent();
	}

}
