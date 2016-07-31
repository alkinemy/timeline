package com.lezhin.timeline.server.interfaces.api.follow.service;

import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.follow.dto.FollowingInsertForm;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.domain.follow.service.FollowFacadeService;
import com.lezhin.timeline.server.interfaces.api.follow.dto.FollowingApiInsertForm;
import com.lezhin.timeline.server.interfaces.api.follow.dto.UnfollowApiForm;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowApiFacadeService {

	@Autowired
	private FollowFacadeService followFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public List<TimelineUserDto> getFollowings(String loginId) {
		List<TimelineUserEntity> followings = followFacadeService.getFollowings(loginId);
		return assembler.assemble(followings, TimelineUserDto.class);
	}

	public void addFollowing(String loginId, FollowingApiInsertForm insertApiForm) {
		FollowingInsertForm insertForm = assembler.assemble(insertApiForm, FollowingInsertForm.class);
		insertForm.setLoginId(loginId);
		followFacadeService.insert(insertForm);
	}

	public void unfollowing(String loginId, UnfollowApiForm unfollowApiForm) {
		FollowDeleteForm followDeleteForm = assembler.assemble(unfollowApiForm, FollowDeleteForm.class);
		followDeleteForm.setLoginId(loginId);
		followFacadeService.delete(followDeleteForm);
	}
}
