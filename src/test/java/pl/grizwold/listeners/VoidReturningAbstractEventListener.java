package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.AbstractEvent;
import pl.grizwold.model.Event3;

import java.util.function.Consumer;

public class VoidReturningAbstractEventListener {
    public Consumer<AbstractEvent> consumer;

    @EventListener
    public void execute(AbstractEvent event) {
        consumer.accept(event);
    }
}