package pl.grizwold.events.async;

import lombok.Value;

@Value
public class AnotherTarEvent extends AnotherEvent {
    private String payload;
}
