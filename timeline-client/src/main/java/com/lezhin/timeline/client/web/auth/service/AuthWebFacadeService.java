package com.lezhin.timeline.client.web.auth.service;

import com.lezhin.timeline.client.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserRegisterForm;
import com.lezhin.timeline.client.domain.user.service.TimelineUserFacadeService;
import com.lezhin.timeline.client.web.auth.dto.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthWebFacadeService {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public void signUp(SignUpForm signUpForm) {
		TimelineUserRegisterForm registerForm = assembler.assemble(signUpForm, TimelineUserRegisterForm.class);
		timelineUserFacadeService.register(registerForm);
	}

}
