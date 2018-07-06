package pl.grizwold.async.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.grizwold.events.BarEvent;
import pl.grizwold.events.FooEvent;
import pl.grizwold.events.async.AnotherBarEvent;
import pl.grizwold.events.async.AnotherFooEvent;

@Slf4j
@Component
public class AnotherFooEventListener {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Async
    @EventListener
    public void execute(AnotherFooEvent event) {
        log.info("Processing {}", event);

        AnotherBarEvent newEvent = new AnotherBarEvent(event.getPayload());
        log.info("Raising {}", newEvent);
        eventPublisher.publishEvent(newEvent);
    }
}
