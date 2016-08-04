package com.lezhin.timeline.server.domain.activity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue(ActivityType.Names.MESSAGE_CREATED)
public class MessageCreatedActivityLogEntity extends ActivityLogEntity {

	private String messageId;

}
