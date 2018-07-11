package pl.grizwold.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.grizwold.events.FooEvent;
import pl.grizwold.events.ZarEvent;

@Slf4j
@Component
public class ZarEventThirdListener {

    @EventListener
    public FooEvent execute(ZarEvent event) {
        log.info("Third processing {} and raising null FooEvent. There should not be any FooEventListener after", event);
        return null;
    }
}
