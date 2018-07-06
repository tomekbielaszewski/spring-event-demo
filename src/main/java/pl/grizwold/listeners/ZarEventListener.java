package pl.grizwold.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.grizwold.events.BarEvent;
import pl.grizwold.events.FooEvent;
import pl.grizwold.events.ZarEvent;

@Slf4j
@Component
public class ZarEventListener {

    @EventListener
    public void execute(ZarEvent event) {
        log.info("Processing {}", event);
    }
}
