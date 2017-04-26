package al.timeline.server.domain.base.event;

import reactor.bus.Event;
import reactor.fn.Consumer;

public interface EventConsumer<T> extends Consumer<Event<T>> {
}
