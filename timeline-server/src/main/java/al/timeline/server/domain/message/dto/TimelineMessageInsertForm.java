package al.timeline.server.domain.message.dto;

import al.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineMessageInsertForm {

	private TimelineUserDto user;
	private String contents;
	private String parentMessageId;

}
