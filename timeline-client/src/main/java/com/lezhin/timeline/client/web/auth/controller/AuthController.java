package com.lezhin.timeline.client.web.auth.controller;

import com.lezhin.timeline.client.web.auth.dto.SignUpForm;
import com.lezhin.timeline.client.web.auth.service.AuthApiFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

	@Autowired
	private AuthApiFacadeService authApiFacadeService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "auth/login";
	}

	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public String signUpPage() {
		return "auth/signup";
	}

	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String signUp(SignUpForm signUpForm) {
		authApiFacadeService.signUp(signUpForm);
		return loginPage();
	}

}
