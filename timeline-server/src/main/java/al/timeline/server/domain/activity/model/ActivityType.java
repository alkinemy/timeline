package al.timeline.server.domain.activity.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum ActivityType {

	MESSAGE_CREATED(Names.MESSAGE_CREATED),
	FOLLOWER_CREATED(Names.FOLLOWER_CREATED),
	FOLLOWING_CREATED(Names.FOLLOWING_CREATED);

	private String typeName;

	ActivityType(String typeName) {
		this.typeName = typeName;
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class Names {
		public static final String MESSAGE_CREATED = "MESSAGE_CREATED";
		public static final String FOLLOWER_CREATED = "FOLLOWER_CREATED";
		public static final String FOLLOWING_CREATED = "FOLLOWING_CREATED";
	}

}
