package pl.grizwold.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.grizwold.events.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class BarEventListener {

    @EventListener
    public List execute(BarEvent event) {
        log.info("Processing {}", event);

        List<Event> events = Arrays.asList(new TarEvent(event.getPayload()), new ZarEvent(event.getPayload()));
        log.info("Raising {}", events);
        return events;
    }
}
