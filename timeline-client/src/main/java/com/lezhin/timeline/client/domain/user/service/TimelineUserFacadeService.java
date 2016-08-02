package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.follow.dto.TimelineFollowInsertForm;
import com.lezhin.timeline.client.domain.follow.service.TimelineFollowAdapterService;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserInsertForm;
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

		TimelineFollowInsertForm followInsertForm = new TimelineFollowInsertForm();
		TimelineUserDto userDto = TimelineUserDto.of(userInsertForm.getLoginId(), userInsertForm.getName());
		followInsertForm.setFollower(userDto);
		followInsertForm.setFollowing(userDto);
		timelineFollowAdapterService.addFollowing(followInsertForm);
	}

	public TimelineUserDto getUser(String targetUserLoginId) {
		return timelineUserAdapterService.getUser(targetUserLoginId);
	}

}
