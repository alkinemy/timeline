package com.lezhin.timeline.server.domain.message.service;

import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.repository.TimelineMessageRepository;
import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineMessageQueryService {

	@Autowired
	private TimelineMessageRepository timelineMessageRepository;

	public List<TimelineMessageEntity> findAll(TimelineUser user) {
		return timelineMessageRepository.findAllByAuthorLoginId(user.getLoginId());
	}
}
