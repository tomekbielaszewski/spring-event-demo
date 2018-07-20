package pl.grizwold.listeners;

import org.springframework.context.event.EventListener;

import java.util.function.Consumer;

public class VoidReturningEventListener<IN> {
    public Consumer<IN> consumer;

    @EventListener
    public void execute(IN event) {
        consumer.accept(event);
    }
}