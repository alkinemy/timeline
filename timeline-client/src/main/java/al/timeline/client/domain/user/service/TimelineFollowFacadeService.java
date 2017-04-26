package al.timeline.client.domain.user.service;

import al.timeline.client.domain.user.dto.TimelineUserFollowForm;
import al.timeline.client.domain.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineFollowFacadeService {

	@Autowired
	private TimelineFollowAdapterService timelineFollowAdapterService;

	public void follow(TimelineUserDto follower, TimelineUserDto following) {
		TimelineUserFollowForm followForm = TimelineUserFollowForm.of(follower, following);
		timelineFollowAdapterService.follow(followForm);
	}

	public void unfollow(TimelineUserDto follower, TimelineUserDto following) {
		TimelineUserFollowForm followForm = TimelineUserFollowForm.of(follower, following);
		timelineFollowAdapterService.unfollow(followForm);
	}

	public List<TimelineUserDto> getFollowings(String loginId) {
		return timelineFollowAdapterService.getFollowings(TimelineUserDto.of(loginId));
	}

	public List<TimelineUserDto> getFollowers(String loginId) {
		return timelineFollowAdapterService.getFollowers(TimelineUserDto.of(loginId));
	}

}
