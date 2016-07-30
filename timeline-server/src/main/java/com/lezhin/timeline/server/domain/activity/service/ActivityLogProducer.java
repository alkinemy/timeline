package com.lezhin.timeline.server.domain.activity.service;

import com.lezhin.timeline.server.domain.base.event.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.EventBus;

@Service
public class ActivityLogProducer implements EventProducer {

	@Autowired
	private EventBus eventBus;

}
