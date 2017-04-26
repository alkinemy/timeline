package al.timeline.client.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TimelineUserDto {

	private String loginId;
	private String name;

	public static TimelineUserDto of(String loginId) {
		return new TimelineUserDto(loginId, null);
	}

}
