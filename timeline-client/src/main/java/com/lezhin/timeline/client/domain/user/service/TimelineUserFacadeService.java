package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.user.dto.*;
import com.lezhin.timeline.client.web.base.response.PagedResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

	public PagedResources<ActivityLogDto> getActivityLogs(ActivityLogSearchConditions conditions) {
		return timelineUserAdapterService.getActivityLogs(conditions);
	}

}
