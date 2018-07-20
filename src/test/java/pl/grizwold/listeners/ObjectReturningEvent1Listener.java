package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event1;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectReturningEvent1Listener {
    public Consumer<Event1> consumer;
    public Supplier supplier;

    @EventListener
    public Object execute(Event1 event1) {
        consumer.accept(event1);
        return supplier.get();
    }
}
