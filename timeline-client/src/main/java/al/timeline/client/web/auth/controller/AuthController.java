package al.timeline.client.web.auth.controller;

import al.timeline.client.web.auth.dto.SignUpForm;
import al.timeline.client.web.auth.service.AuthWebFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

	@Autowired
	private AuthWebFacadeService authWebFacadeService;

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
		authWebFacadeService.signUp(signUpForm);
		return loginPage();
	}

}
