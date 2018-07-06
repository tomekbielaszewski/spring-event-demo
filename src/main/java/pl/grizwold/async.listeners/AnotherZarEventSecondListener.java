package pl.grizwold.async.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.grizwold.events.async.AnotherZarEvent;

@Slf4j
@Component
public class AnotherZarEventSecondListener {

    @Async
    @EventListener
    public void execute(AnotherZarEvent event) {
        log.info("Second processing {}", event);
    }
}
