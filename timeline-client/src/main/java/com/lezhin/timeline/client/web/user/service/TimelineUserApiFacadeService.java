package com.lezhin.timeline.client.web.user.service;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.service.TimelineUserFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserApiFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	public TimelineUserDto getUser(String targetUserLoginId) {
		return timelineUserFacadeService.getUser(targetUserLoginId);
	}

}
