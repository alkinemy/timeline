package com.lezhin.timeline.server.domain.activity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue(ActivityType.Names.FOLLOWING_CREATED)
public class FollowingCreatedActivityLogEntity extends ActivityLogEntity {
}
