package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event2;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectReturningEvent2Listener {
    public Consumer<Event2> consumer;
    public Supplier supplier;

    @EventListener
    public Object execute(Event2 event) {
        consumer.accept(event);
        return supplier.get();
    }
}
