package al.timeline.client.web.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserMessagesSearchParam {

	private Integer size;
	private String lastTimelineMessageId;

}
