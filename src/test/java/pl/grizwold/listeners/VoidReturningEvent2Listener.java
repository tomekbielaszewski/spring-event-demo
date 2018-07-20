package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event2;

import java.util.function.Consumer;

public class VoidReturningEvent2Listener {
    public Consumer<Event2> consumer;

    @EventListener
    public void execute(Event2 event) {
        consumer.accept(event);
    }
}