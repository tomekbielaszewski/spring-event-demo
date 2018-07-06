package pl.grizwold.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.grizwold.events.BarEvent;
import pl.grizwold.events.FooEvent;

@Slf4j
@Component
public class FooEventListener {

    @EventListener
    public BarEvent execute(FooEvent event) {
        log.info("Processing {}", event);

        BarEvent newEvent = new BarEvent(event.getPayload());
        log.info("Raising {}", newEvent);
        return newEvent;
    }
}
