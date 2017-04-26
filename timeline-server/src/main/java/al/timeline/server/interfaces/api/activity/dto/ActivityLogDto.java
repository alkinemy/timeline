package al.timeline.server.interfaces.api.activity.dto;

import al.timeline.server.domain.activity.model.ActivityType;
import al.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class ActivityLogDto {

	private TimelineUserDto from;
	private ActivityType type;
	private LocalDateTime activityDate;

}
