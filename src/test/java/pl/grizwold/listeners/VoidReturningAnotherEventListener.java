package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.AbstractEvent;
import pl.grizwold.model.AnotherEvent;

import java.util.function.Consumer;

public class VoidReturningAnotherEventListener {
    public Consumer<AnotherEvent> consumer;

    @EventListener
    public void execute(AnotherEvent event) {
        consumer.accept(event);
    }
}