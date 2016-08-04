package com.lezhin.timeline.server.domain.activity.service;

import com.lezhin.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import com.lezhin.timeline.server.domain.base.event.EventConsumer;
import com.lezhin.timeline.server.domain.base.event.EventNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

import javax.annotation.PostConstruct;

import static reactor.bus.selector.Selectors.$;

@Slf4j
@Service
public class FollowerCreatedEventConsumer implements EventConsumer<FollowCreatedEventForm> {

	@Autowired
	private ActivityLogFacadeService activityLogFacadeService;

	@Autowired
	private EventBus eventBus;

	@PostConstruct
	public void initialize() {
		eventBus.on($(EventNameConstants.FOLLOWER_CREATED), this);
	}

	@Override
	public void accept(Event<FollowCreatedEventForm> event) {
		log.debug("FOLLOWER_CREATED event consuming start: {}", event.getData());
		activityLogFacadeService.logFollowerCreatedEvent(event.getData());
	}

}
