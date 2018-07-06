package pl.grizwold.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.grizwold.events.BarEvent;
import pl.grizwold.events.FooEvent;
import pl.grizwold.events.TarEvent;
import pl.grizwold.events.ZarEvent;

@Slf4j
@Component
public class TarEventListener {

    @EventListener
    public ZarEvent execute(TarEvent event) {
        log.info("Processing {}", event);

        ZarEvent newEvent = new ZarEvent(event.getPayload());
        log.info("Raising {}", newEvent);
        return newEvent;
    }
}
