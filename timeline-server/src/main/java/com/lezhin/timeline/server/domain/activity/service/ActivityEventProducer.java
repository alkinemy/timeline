package com.lezhin.timeline.server.domain.activity.service;

import com.lezhin.timeline.server.domain.base.event.EventNameConstants;
import com.lezhin.timeline.server.domain.base.event.EventProducer;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Service
public class ActivityEventProducer implements EventProducer {

	@Autowired
	private EventBus eventBus;

	public void triggerFollowerCreatedEvent(String loginId, String followingLoginId) {
		eventBus.notify(EventNameConstants.FOLLOWER_CREATED, Event.wrap(Pair.of(loginId, followingLoginId)));
	}

	public void triggerTimelineMessageCreatedEvent(String messageId) {
		eventBus.notify(EventNameConstants.MESSAGE_CREATED, Event.wrap(messageId));
	}

}
