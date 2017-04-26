package al.timeline.client.domain.activity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultActivityLogDto extends ActivityLogDto {

	@Override
	public String buildLink() {
		return new StringBuilder().append("/")
			.append(getFrom().getLoginId()).toString();
	}

}
