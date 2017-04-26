package al.timeline.client.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserDetailsDto {

	private String loginId;
	private String name;
	private String password;

}
