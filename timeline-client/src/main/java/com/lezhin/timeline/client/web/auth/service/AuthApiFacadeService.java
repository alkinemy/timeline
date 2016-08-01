package com.lezhin.timeline.client.web.auth.service;

import com.lezhin.timeline.client.domain.user.dto.TimelineUserInsertForm;
import com.lezhin.timeline.client.domain.user.service.TimelineUserFacadeService;
import com.lezhin.timeline.client.web.auth.dto.SignUpForm;
import com.lezhin.timeline.common.domain.base.assembler.SmartAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthApiFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public void signUp(SignUpForm signUpForm) {
		TimelineUserInsertForm insertForm = assembler.assemble(signUpForm, TimelineUserInsertForm.class);
		timelineUserFacadeService.insert(insertForm);
	}

}
