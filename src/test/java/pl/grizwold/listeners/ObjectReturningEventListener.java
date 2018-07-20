package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectReturningEventListener<T> {
    public Consumer<Event> consumer;
    public Supplier<T> supplier;

    @EventListener
    public T execute(Event event) {
        consumer.accept(event);
        return supplier.get();
    }
}
