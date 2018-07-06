package pl.grizwold.events;

import lombok.Value;

@Value
public class FooEvent extends Event {
    private String payload;
}
