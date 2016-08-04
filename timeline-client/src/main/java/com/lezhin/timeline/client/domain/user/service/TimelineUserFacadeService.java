package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserAdapterService timelineUserAdapterService;
	@Autowired
	private TimelineFollowFacadeService timelineFollowFacadeService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void register(TimelineUserRegisterForm registerForm) {
		registerForm.setPassword(passwordEncoder.encode(registerForm.getPassword()));
		timelineUserAdapterService.registerUser(registerForm);

		TimelineUserDto userDto = TimelineUserDto.of(registerForm.getLoginId(), registerForm.getName());
		timelineFollowFacadeService.follow(userDto, userDto);
	}

	public TimelineUserDto getUser(String loginId) {
		TimelineUserDto user = timelineUserAdapterService.getUser(loginId);
		return TimelineUserDto.of(user.getLoginId(), user.getName());
	}

}
