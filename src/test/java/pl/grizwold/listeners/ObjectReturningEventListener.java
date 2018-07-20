package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectReturningEventListener<IN, OUT> {
    public Consumer<IN> consumer;
    public Supplier<OUT> supplier;

    @EventListener
    public OUT execute(IN event) {
        consumer.accept(event);
        return supplier.get();
    }
}
