package al.timeline.client.domain.message.dto;

import al.timeline.client.domain.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimelineMessageDto {

	private String messageId;
	private TimelineUserDto author;
	private String contents;
	private String parentMessageId;
	private LocalDateTime messageDate;

}
