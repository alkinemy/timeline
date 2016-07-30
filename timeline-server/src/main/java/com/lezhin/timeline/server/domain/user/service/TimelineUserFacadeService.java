package com.lezhin.timeline.server.domain.user.service;

import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.base.exception.Exceptions;
import com.lezhin.timeline.server.domain.base.exception.TimelineErrorCode;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.server.interfaces.api.user.dto.TimelineUserInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserQueryService timelineUserQueryService;

	@Autowired
	private TimelineUserCommandService timelineUserCommandService;

	@Autowired
	private SmartAssembler assembler;

	public TimelineUserEntity getTimelineUser(String loginId) {
		return timelineUserQueryService.findOneByLoginId(loginId)
			.orElseThrow(() -> Exceptions.newException(TimelineErrorCode.ENTITY_NOT_FOUND, loginId));
	}

	@Transactional(readOnly = true)
	public List<TimelineUserEntity> getFollowings(String loginId) {
		TimelineUserEntity timelineUser = getTimelineUser(loginId);
		timelineUser.getFollowings().size(); //강제 로딩을 위해 호출
		return timelineUser.getFollowings();
	}

	public void insert(TimelineUserInsertForm insertForm) {
		TimelineUserEntity entity = assembler.assemble(insertForm, TimelineUserEntity.class);
		timelineUserCommandService.insert(entity);
	}

}
