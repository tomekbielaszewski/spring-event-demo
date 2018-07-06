package pl.grizwold.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.grizwold.events.Event;

@Slf4j
@Component
public class EventListener {

    @org.springframework.context.event.EventListener
    public void execute(Event event) {
        log.info("Processing {}", event);
    }
}
