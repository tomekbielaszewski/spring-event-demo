package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.model.AbstractEvent;
import pl.grizwold.model.Event1;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectReturningAbstractEventListener {
    public Consumer<AbstractEvent> consumer;
    public Supplier supplier;

    @EventListener
    public Object execute(AbstractEvent event) {
        consumer.accept(event);
        return supplier.get();
    }
}
