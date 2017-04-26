package al.timeline.server.domain.common.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class TimelineUser {

	@Column(name = "login_id")
	private String loginId;

	@Column(name = "name")
	private String name;

}
