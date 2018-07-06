package pl.grizwold.events.async;

import lombok.Value;

@Value
public class AnotherZarEvent extends AnotherEvent {
    private String payload;
}
