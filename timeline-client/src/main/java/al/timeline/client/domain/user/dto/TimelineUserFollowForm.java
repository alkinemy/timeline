package al.timeline.client.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TimelineUserFollowForm {

	private TimelineUserDto follower;
	private TimelineUserDto following;

}
