package com.lezhin.timeline.server.interfaces.api.follow.service;

import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.domain.user.service.FollowingFacadeService;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingApiFacadeService {

	@Autowired
	private FollowingFacadeService followingFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public List<TimelineUserDto> getFollowings(String loginId) {
		List<TimelineUserEntity> followings = followingFacadeService.getFollowings(loginId);
		return assembler.assemble(followings, TimelineUserDto.class);
	}
}
