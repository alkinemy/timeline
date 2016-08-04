package com.lezhin.timeline.client.web.user.service;

import com.lezhin.timeline.client.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.client.domain.user.service.TimelineFollowFacadeService;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserDto;
import com.lezhin.timeline.client.domain.user.model.TimelineUser;
import com.lezhin.timeline.client.domain.user.service.TimelineUserFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineFollowWebFacadeService {

	@Autowired
	private TimelineFollowFacadeService timelineFollowFacadeService;
	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public void follow(TimelineUser follower, String followingLoginId) {
		TimelineUserDto followerDto = assembler.assemble(follower, TimelineUserDto.class);
		TimelineUserDto followingDto = timelineUserFacadeService.getUser(followingLoginId);
		timelineFollowFacadeService.follow(followerDto, followingDto);
	}

	public void unfollow(TimelineUser follower, String followingLoginId) {
		TimelineUserDto followerDto = assembler.assemble(follower, TimelineUserDto.class);
		TimelineUserDto followingDto = timelineUserFacadeService.getUser(followingLoginId);
		timelineFollowFacadeService.unfollow(followerDto, followingDto);
	}

	public List<TimelineUserDto> getFollowings(String loginId) {
		return timelineFollowFacadeService.getFollowings(loginId);
	}

	public List<TimelineUserDto> getFollowers(String loginId) {
		return timelineFollowFacadeService.getFollowers(loginId);
	}

}
