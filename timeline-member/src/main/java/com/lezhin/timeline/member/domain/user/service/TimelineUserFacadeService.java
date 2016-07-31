package com.lezhin.timeline.member.domain.user.service;

import com.lezhin.timeline.common.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.common.domain.base.exception.Exceptions;
import com.lezhin.timeline.member.domain.base.exception.TimelineErrorCode;
import com.lezhin.timeline.member.domain.user.model.TimelineUserEntity;
import com.lezhin.timeline.member.interfaces.api.user.dto.TimelineUserInsertForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimelineUserFacadeService {

	@Autowired
	private TimelineUserQueryService timelineUserQueryService;

	@Autowired
	private TimelineUserCommandService timelineUserCommandService;

	@Autowired
	private SmartAssembler assembler;

	@Transactional(readOnly = true)
	public TimelineUserEntity getTimelineUser(String loginId) {
		return timelineUserQueryService.findOneByLoginId(loginId)
			.orElseThrow(() -> Exceptions.newException(TimelineErrorCode.ENTITY_NOT_FOUND, loginId));
	}

	public void insert(TimelineUserInsertForm insertForm) {
		TimelineUserEntity entity = assembler.assemble(insertForm, TimelineUserEntity.class);
		timelineUserCommandService.insert(entity);
	}

}
