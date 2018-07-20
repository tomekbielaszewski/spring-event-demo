package pl.grizwold.demo1;

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

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SingleEventListenerDemo.Config.class)
public class SingleEventListenerDemo {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private VoidReturningEventListener eventListener;

    @Mock
    private Consumer<Event> mockConsumer;

    @Test
    public void should_execute_listener_when_raising_single_event() throws Exception {
        eventListener.consumer = mockConsumer;
        Event event = new Event();
        event.name = "single event";
        eventPublisher.publishEvent(event);

        verify(mockConsumer).accept(event);
    }

    @Configuration
    static class Config {
        @Bean
        public VoidReturningEventListener voidReturningEventListener() {
            return new VoidReturningEventListener();
        }
    }
}