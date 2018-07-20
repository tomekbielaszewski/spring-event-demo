package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event1;

import java.util.function.Consumer;

public class VoidReturningEvent1Listener {
    public Consumer<Event1> consumer;

    @EventListener
    public void execute(Event1 event) {
        consumer.accept(event);
    }
}