package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event3;

import java.util.function.Consumer;

public class VoidReturningEvent3Listener {
    public Consumer<Event3> consumer;

    @EventListener
    public void execute(Event3 event) {
        consumer.accept(event);
    }
}