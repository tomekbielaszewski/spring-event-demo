package pl.grizwold;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pl.grizwold.events.FooEvent;
import pl.grizwold.events.async.AnotherFooEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@EnableAsync
@SpringBootApplication
public class SpringEventDemoApplication implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		return Executors.newFixedThreadPool(4);
	}

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringEventDemoApplication.class, args);
		context.getBean(SpringEventDemoApplication.class).run();

		Thread.sleep(10);
	}

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	private void run() {
		log.info("Publishing event...");
		eventPublisher.publishEvent(new FooEvent("Kaboom!!"));

		log.info("Publishing async event...");
		eventPublisher.publishEvent(new AnotherFooEvent("Kaboom!!"));
	}
}
