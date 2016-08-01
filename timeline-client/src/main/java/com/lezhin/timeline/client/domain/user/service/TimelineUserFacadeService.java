package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.message.service.TimelineMessageAdapterService;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserAdapterService timelineUserAdapterService;
	@Autowired
	private TimelineMessageAdapterService timelineMessageAdapterService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void insert(TimelineUserInsertForm insertForm) {
		insertForm.setPassword(passwordEncoder.encode(insertForm.getPassword()));
		timelineUserAdapterService.registerUser(insertForm);
	}

}
