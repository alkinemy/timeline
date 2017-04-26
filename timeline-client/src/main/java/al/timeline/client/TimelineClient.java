package al.timeline.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimelineClient {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TimelineClient.class);
		springApplication.run(args);
	}

}
