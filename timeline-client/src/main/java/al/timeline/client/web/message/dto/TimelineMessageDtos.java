package al.timeline.client.web.message.dto;

import al.timeline.client.domain.message.dto.TimelineMessageDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TimelineMessageDtos {

	private List<TimelineMessageDto> messages;
	private String lastTimelineMessageId;

}
