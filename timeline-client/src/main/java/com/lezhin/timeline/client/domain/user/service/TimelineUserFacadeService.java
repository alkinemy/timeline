package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserFollowForm;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserAdapterService timelineUserAdapterService;
	@Autowired
	private TimelineFollowAdapterService timelineFollowAdapterService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void insert(TimelineUserInsertForm userInsertForm) {
		userInsertForm.setPassword(passwordEncoder.encode(userInsertForm.getPassword()));
		timelineUserAdapterService.registerUser(userInsertForm);

		TimelineUserDto userDto = TimelineUserDto.of(userInsertForm.getLoginId(), userInsertForm.getName());
		follow(userDto, userDto);
	}

	public void follow(TimelineUserDto follower, TimelineUserDto following) {
		TimelineUserFollowForm followForm = new TimelineUserFollowForm();
		followForm.setFollower(follower);
		followForm.setFollowing(following);
		timelineFollowAdapterService.addFollowing(followForm);
	}

	public TimelineUserDto getUser(String targetUserLoginId) {
		TimelineUserDto user = timelineUserAdapterService.getUser(targetUserLoginId);
		//TODO 임시처리..
		return TimelineUserDto.of(user.getLoginId(), user.getName());
	}

	public void unfollow(TimelineUserDto follower, TimelineUserDto following) {
		TimelineUserFollowForm followForm = new TimelineUserFollowForm();
		followForm.setFollower(follower);
		followForm.setFollowing(following);
		timelineFollowAdapterService.removeFollowing(followForm);
	}

	public List<TimelineUserDto> getFollowings(String loginId) {
		return timelineFollowAdapterService.getFollowings(TimelineUserDto.of(loginId));
	}

	public List<TimelineUserDto> getFollowers(String loginId) {
		return timelineFollowAdapterService.getFollowers(TimelineUserDto.of(loginId));
	}
}
