package al.timeline.member.interfaces.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(path = "/hello")
	public String hello() {
		return "Hello member!";
	}

}
