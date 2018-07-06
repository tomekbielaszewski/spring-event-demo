package pl.grizwold.events;

import lombok.Value;

@Value
public class TarEvent extends Event {
    private String payload;
}
