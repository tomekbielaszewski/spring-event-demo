package pl.grizwold.events.async;

import lombok.Value;

@Value
public class AnotherBarEvent extends AnotherEvent {
    private String payload;
}
