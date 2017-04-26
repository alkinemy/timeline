package al.timeline.client.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimelineUserRegisterForm {

	private String loginId;
	private String name;
	private String password;

}
