package com.lezhin.timeline.client.web.user.service;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.domain.user.service.TimelineUserFacadeService;
import com.lezhin.timeline.common.domain.base.assembler.SmartAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineUserApiFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public TimelineUserDto getUser(String targetUserLoginId) {
		return timelineUserFacadeService.getUser(targetUserLoginId);
	}

	public void follow(TimelineUser follower, String followingLoginId) {
		TimelineUserDto followerDto = assembler.assemble(follower, TimelineUserDto.class);
		TimelineUserDto followingDto = timelineUserFacadeService.getUser(followingLoginId);
		timelineUserFacadeService.follow(followerDto, followingDto);
	}

	public void unfollow(TimelineUser follower, String followingLoginId) {
		TimelineUserDto followerDto = assembler.assemble(follower, TimelineUserDto.class);
		TimelineUserDto followingDto = timelineUserFacadeService.getUser(followingLoginId);
		timelineUserFacadeService.unfollow(followerDto, followingDto);
	}

}