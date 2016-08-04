package com.lezhin.timeline.server.interfaces.api.follow.service;

import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import com.lezhin.timeline.server.domain.follow.dto.TimelineFollowDeleteForm;
import com.lezhin.timeline.server.domain.follow.dto.TimelineFollowingInsertForm;
import com.lezhin.timeline.server.domain.follow.service.TimelineFollowFacadeService;
import com.lezhin.timeline.server.interfaces.api.follow.dto.FollowingApiInsertForm;
import com.lezhin.timeline.server.interfaces.api.follow.dto.UnfollowApiForm;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineFollowApiFacadeService {

	@Autowired
	private TimelineFollowFacadeService timelineFollowFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		List<TimelineUser> followings = timelineFollowFacadeService.getFollowings(user.getLoginId());
		return assembler.assemble(followings, TimelineUserDto.class);
	}

	public List<TimelineUserDto> getFollowers(TimelineUserDto user) {
		List<TimelineUser> followers = timelineFollowFacadeService.getFollowers(user.getLoginId());
		return assembler.assemble(followers, TimelineUserDto.class);
	}

	public void addFollowing(FollowingApiInsertForm insertApiForm) {
		TimelineFollowingInsertForm insertForm = assembler.assemble(insertApiForm, TimelineFollowingInsertForm.class);
		timelineFollowFacadeService.insert(insertForm);
	}

	public void unfollowing(UnfollowApiForm unfollowApiForm) {
		TimelineFollowDeleteForm timelineFollowDeleteForm = assembler.assemble(unfollowApiForm, TimelineFollowDeleteForm.class);
		timelineFollowFacadeService.delete(timelineFollowDeleteForm);
	}

}
