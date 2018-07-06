package pl.grizwold.async.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.grizwold.events.Event;
import pl.grizwold.events.async.AnotherEvent;

@Slf4j
@Component
public class AnotherEventListener {

    @Async
    @org.springframework.context.event.EventListener
    public void execute(AnotherEvent event) {
        log.info("Processing {}", event);
    }
}
