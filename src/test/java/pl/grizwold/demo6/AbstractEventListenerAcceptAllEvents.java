package pl.grizwold.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.grizwold.listeners.VoidReturningAbstractEventListener;
import pl.grizwold.model.AbstractEvent;
import pl.grizwold.model.Event1;
import pl.grizwold.model.Event2;
import pl.grizwold.model.Event3;

import java.util.function.Consumer;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AbstractEventListenerAcceptAllEvents.Config.class)
public class AbstractEventListenerAcceptAllEvents {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private VoidReturningAbstractEventListener listener;

    @Mock
    private Consumer<AbstractEvent> mockConsumer;

    @Test
    public void should_execute_listener_when_event1_was_raised() throws Exception {
        Event1 event1 = new Event1();
        listener.consumer = mockConsumer;

        eventPublisher.publishEvent(event1);

        verify(mockConsumer).accept(event1);
    }

    @Test
    public void should_execute_listener_when_event2_was_raised() throws Exception {
        Event2 event2 = new Event2();
        listener.consumer = mockConsumer;

        eventPublisher.publishEvent(event2);

        verify(mockConsumer).accept(event2);
    }

    @Test
    public void should_execute_listener_when_event3_was_raised() throws Exception {
        Event3 event3 = new Event3();
        listener.consumer = mockConsumer;

        eventPublisher.publishEvent(event3);

        verify(mockConsumer).accept(event3);
    }

    @Configuration
    static class Config {
        @Bean
        public VoidReturningAbstractEventListener listener() {
            return new VoidReturningAbstractEventListener();
        }
    }
}
