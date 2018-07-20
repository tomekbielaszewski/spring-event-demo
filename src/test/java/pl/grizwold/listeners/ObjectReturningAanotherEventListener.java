package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.AbstractEvent;
import pl.grizwold.model.AnotherEvent;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectReturningAanotherEventListener {
    public Consumer<AnotherEvent> consumer;
    public Supplier supplier;

    @EventListener
    public Object execute(AnotherEvent event) {
        consumer.accept(event);
        return supplier.get();
    }
}
