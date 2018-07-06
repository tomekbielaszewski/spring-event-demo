package pl.grizwold.events;

import lombok.Value;

@Value
public class ZarEvent extends Event {
    private String payload;
}
