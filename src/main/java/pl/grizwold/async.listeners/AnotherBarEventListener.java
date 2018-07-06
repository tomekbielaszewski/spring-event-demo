package pl.grizwold.async.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.grizwold.events.BarEvent;
import pl.grizwold.events.Event;
import pl.grizwold.events.TarEvent;
import pl.grizwold.events.ZarEvent;
import pl.grizwold.events.async.AnotherBarEvent;
import pl.grizwold.events.async.AnotherEvent;
import pl.grizwold.events.async.AnotherTarEvent;
import pl.grizwold.events.async.AnotherZarEvent;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class AnotherBarEventListener {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Async
    @EventListener
    public void execute(AnotherBarEvent event) {
        log.info("Processing {}", event);

        List<AnotherEvent> events = Arrays.asList(new AnotherTarEvent(event.getPayload()), new AnotherZarEvent(event.getPayload()));
        log.info("Raising {}", events);
        events.forEach(eventPublisher::publishEvent);
    }
}
