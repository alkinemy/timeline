package com.lezhin.timeline.client.domain.activity.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lezhin.timeline.client.domain.activity.model.ActivityType;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonTypeInfo(
	use=JsonTypeInfo.Id.NAME,
	include=JsonTypeInfo.As.EXTERNAL_PROPERTY,
	property = "type",
	visible = true,
	defaultImpl = DefaultActivityLogDto.class)
@JsonSubTypes({
	@JsonSubTypes.Type(value = MessageCreatedActivityLogDto.class, name = ActivityType.Names.MESSAGE_CREATED)
})
public abstract class ActivityLogDto implements MessageProvidable {

	private TimelineUserDto from;
	private ActivityType type;
	private LocalDateTime activityDate;

	@Override
	public String buildMessage() {
		return new StringBuilder()
			.append(from.getName())
			.append(type.getBaseMessage())
			.toString();
	}

	public abstract String buildLink();

}
