package com.lezhin.timeline.client.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityLogSearchConditions {

	private String loginId;
	private Integer page;
	private Integer size;

}
