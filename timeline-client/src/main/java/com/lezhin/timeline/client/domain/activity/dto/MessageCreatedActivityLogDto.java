package com.lezhin.timeline.client.domain.activity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageCreatedActivityLogDto extends ActivityLogDto {

	private String messageId;

	@Override
	public String buildLink() {
		return new StringBuilder()
			.append("/").append(getFrom().getLoginId())
			.append("/messages/").append(messageId)
			.toString();
	}

}
