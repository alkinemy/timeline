package com.lezhin.timeline.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
@Controller
public class HelloController {

	@RequestMapping(path = "")
	public String hello() {
		return "hello";
	}

}
