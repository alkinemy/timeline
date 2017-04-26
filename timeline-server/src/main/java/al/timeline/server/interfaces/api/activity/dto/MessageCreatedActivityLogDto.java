package al.timeline.server.interfaces.api.activity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageCreatedActivityLogDto extends ActivityLogDto {

	private String messageId;

}
