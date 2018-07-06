package pl.grizwold;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import pl.grizwold.events.FooEvent;

@Slf4j
@SpringBootApplication
public class SpringEventDemoApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringEventDemoApplication.class, args);
		context.getBean(SpringEventDemoApplication.class).run();
	}

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	private void run() {
		log.info("Publishing first event...");
		eventPublisher.publishEvent(new FooEvent("Kaboom!!"));
	}
}
