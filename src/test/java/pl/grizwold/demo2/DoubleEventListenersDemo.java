package pl.grizwold.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.grizwold.listeners.VoidReturningEventListener;
import pl.grizwold.model.Event;

import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DoubleEventListenersDemo.Config.class)
public class DoubleEventListenersDemo {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private VoidReturningEventListener first;

    @Autowired
    private VoidReturningEventListener second;

    @Mock
    private Consumer<Event> firstMockConsumer;

    @Mock
    private Consumer<Event> secondMockConsumer;

    @Test
    public void should_execute_listener_when_raising_single_event() throws Exception {
        first.consumer = firstMockConsumer;
        second.consumer = secondMockConsumer;

        Event event = new Event();
        event.name = "single event";
        eventPublisher.publishEvent(event);

        Mockito.verify(firstMockConsumer).accept(event);
        Mockito.verify(secondMockConsumer).accept(event);
    }

    @Configuration
    static class Config {
        @Bean
        public VoidReturningEventListener first() {
            return new VoidReturningEventListener();
        }

        @Bean
        public VoidReturningEventListener second() {
            return new VoidReturningEventListener();
        }
    }
}
