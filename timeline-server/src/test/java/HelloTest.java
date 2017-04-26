import al.timeline.server.TimelineServer;
import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TimelineServer.class })
@ActiveProfiles("local")
public class HelloTest {

	@Test
	public void test() {
		Assertions.assertThat(true).isTrue();
	}

}
