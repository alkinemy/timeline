package al.timeline.server.domain.activity.service;

import al.timeline.server.domain.activity.dto.FollowCreatedEventForm;
import al.timeline.server.domain.base.event.EventProducer;
import al.timeline.server.domain.base.event.EventNameConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Service
public class ActivityEventProducer implements EventProducer {

	@Autowired
	private EventBus eventBus;

	public void triggerFollowCreatedEvent(FollowCreatedEventForm form) {
		eventBus.notify(EventNameConstants.FOLLOWER_CREATED, Event.wrap(form));
	}

	public void triggerTimelineMessageCreatedEvent(String messageId) {
		eventBus.notify(EventNameConstants.MESSAGE_CREATED, Event.wrap(messageId));
	}

}
