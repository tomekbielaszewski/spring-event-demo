package pl.grizwold.events;

import lombok.Value;

@Value
public class BarEvent extends Event {
    private String payload;
}
