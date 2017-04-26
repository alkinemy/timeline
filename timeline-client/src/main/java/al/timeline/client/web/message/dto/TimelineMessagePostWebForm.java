package al.timeline.client.web.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessagePostWebForm {

	private String contents;
	private String parentMessageId;

}
