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

	public void addFollowing(TimelineUserDto user, FollowingApiInsertForm insertApiForm) {
		TimelineFollowingInsertForm insertForm = assembler.assemble(insertApiForm, TimelineFollowingInsertForm.class);
		insertForm.setFollower(user);
		timelineFollowFacadeService.insert(insertForm);
	}

	public void unfollowing(TimelineUserDto user, UnfollowApiForm unfollowApiForm) {
		TimelineFollowDeleteForm timelineFollowDeleteForm = assembler.assemble(unfollowApiForm, TimelineFollowDeleteForm.class);
		timelineFollowDeleteForm.setLoginId(user.getLoginId());
		timelineFollowFacadeService.delete(timelineFollowDeleteForm);
	}

}
