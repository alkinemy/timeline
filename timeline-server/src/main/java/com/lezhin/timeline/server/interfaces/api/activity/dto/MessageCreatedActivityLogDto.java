package com.lezhin.timeline.server.interfaces.api.activity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonTypeName(ActivityType.Names.MESSAGE_CREATED)
public class MessageCreatedActivityLogDto extends ActivityLogDto {

	private String messageId;

}
