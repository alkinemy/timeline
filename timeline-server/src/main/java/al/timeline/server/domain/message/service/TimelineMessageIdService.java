package al.timeline.server.domain.message.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TimelineMessageIdService {

	public String generate() {
		return UUID.randomUUID().toString();
	}

}
