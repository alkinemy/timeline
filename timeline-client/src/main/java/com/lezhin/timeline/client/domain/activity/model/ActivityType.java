package com.lezhin.timeline.client.domain.activity.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum ActivityType {

	MESSAGE_CREATED(Names.MESSAGE_CREATED, "님이 새 글을 올렸습니다."),
	FOLLOWER_CREATED(Names.FOLLOWER_CREATED, "님을 팔로우했습니다."),
	FOLLOWING_CREATED(Names.FOLLOWING_CREATED, "님이 당신을 팔로우했습니다.");

	private String typeName;
	private String baseMessage;

	ActivityType(String typeName, String baseMessage) {
		this.typeName = typeName;
		this.baseMessage = baseMessage;
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class Names {
		public static final String MESSAGE_CREATED = "MESSAGE_CREATED";
		public static final String FOLLOWER_CREATED = "FOLLOWER_CREATED";
		public static final String FOLLOWING_CREATED = "FOLLOWING_CREATED";
	}

}
