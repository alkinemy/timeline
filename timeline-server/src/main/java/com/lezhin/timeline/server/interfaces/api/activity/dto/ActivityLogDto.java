package com.lezhin.timeline.server.interfaces.api.activity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lezhin.timeline.server.domain.activity.model.ActivityType;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type", defaultImpl = DefaultActivityLogDto.class)
@JsonSubTypes({
	@JsonSubTypes.Type(value = MessageCreatedActivityLogDto.class, name = ActivityType.Names.MESSAGE_CREATED),
})
public abstract class ActivityLogDto {

	private TimelineUserDto from;

	@JsonProperty("type")
	private ActivityType type;
	private LocalDateTime activityDate;

}
