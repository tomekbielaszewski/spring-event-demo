package pl.grizwold.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.grizwold.events.ZarEvent;

@Slf4j
@Component
public class ZarEventSecondListener {

    @EventListener
    public void execute(ZarEvent event) {
        log.info("Second processing {}", event);
    }
}
