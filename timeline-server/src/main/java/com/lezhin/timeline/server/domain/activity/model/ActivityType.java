package com.lezhin.timeline.server.domain.activity.model;

import lombok.Getter;

@Getter
public enum ActivityType {

	MESSAGE_CREATED("님이 새 글을 올리셨습니다."),
	FOLLOWER_CREATED("님이 당신을 팔로우했습니다.");

	private String baseMessage;

	ActivityType(String baseMessage) {
		this.baseMessage = baseMessage;
	}

	public String buildMessage(String userName) {
		StringBuilder builder = new StringBuilder();
		builder.append(userName).append(baseMessage);
		return builder.toString();
	}

}
