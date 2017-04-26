package al.timeline.server.domain.follow.dto;

import al.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineFollowDeleteForm {

	private TimelineUserDto follower;
	private TimelineUserDto following;

}
