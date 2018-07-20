package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event;

import java.util.function.Consumer;

public class VoidReturningEventListener {
    public Consumer<Event> consumer;

    @EventListener
    public void execute(Event event) {
        consumer.accept(event);
    }
}