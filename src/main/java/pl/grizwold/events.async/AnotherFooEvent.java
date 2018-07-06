package pl.grizwold.events.async;

import lombok.Value;

@Value
public class AnotherFooEvent extends AnotherEvent {
    private String payload;
}
