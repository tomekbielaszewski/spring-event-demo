package pl.grizwold.async.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.grizwold.events.TarEvent;
import pl.grizwold.events.ZarEvent;
import pl.grizwold.events.async.AnotherTarEvent;
import pl.grizwold.events.async.AnotherZarEvent;

@Slf4j
@Component
public class AnotherTarEventListener {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Async
    @EventListener
    public void execute(AnotherTarEvent event) {
        log.info("Processing {}", event);

        AnotherZarEvent newEvent = new AnotherZarEvent(event.getPayload());
        log.info("Raising {}", newEvent);

        eventPublisher.publishEvent(newEvent);
    }
}
