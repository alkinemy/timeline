package com.lezhin.timeline.server.domain.activity.service;

import com.lezhin.timeline.server.domain.base.event.EventConsumer;
import com.lezhin.timeline.server.domain.base.event.EventNameConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

import javax.annotation.PostConstruct;

import static reactor.bus.selector.Selectors.$;

@Service
public class FollowingCreatedEventConsumer implements EventConsumer<Pair<String, String>> {

	@Autowired
	private EventBus eventBus;

	@PostConstruct
	public void initialize() {
		eventBus.on($(EventNameConstants.FOLLOWER_CREATED), this);
	}

	@Override
	public void accept(Event<Pair<String, String>> follow) {
	}

}
