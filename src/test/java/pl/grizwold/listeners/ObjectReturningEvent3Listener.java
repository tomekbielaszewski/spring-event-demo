package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.Event3;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectReturningEvent3Listener {
    public Consumer<Event3> consumer;
    public Supplier supplier;

    @EventListener
    public Object execute(Event3 event) {
        consumer.accept(event);
        return supplier.get();
    }
}
