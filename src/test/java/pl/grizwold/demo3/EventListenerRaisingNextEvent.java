package pl.grizwold.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.grizwold.listeners.ObjectReturningEvent1Listener;
import pl.grizwold.listeners.VoidReturningEvent2Listener;
import pl.grizwold.model.Event1;
import pl.grizwold.model.Event2;

import java.util.function.Consumer;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventListenerRaisingNextEvent.Config.class)
public class EventListenerRaisingNextEvent {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private ObjectReturningEvent1Listener first;

    @Autowired
    private VoidReturningEvent2Listener second;

    @Mock
    private Consumer<Event1> firstMockConsumer;

    @Mock
    private Consumer<Event2> secondMockConsumer;

    @Test
    public void should_execute_listeners_in_chain_when_first_listener_is_returning_next_event() throws Exception {
        Event1 event1 = new Event1();
        Event2 event2 = new Event2();

        first.consumer = firstMockConsumer;
        first.supplier = () -> event2;

        second.consumer = secondMockConsumer;

        eventPublisher.publishEvent(event1);

        verify(firstMockConsumer).accept(event1);
        verify(secondMockConsumer).accept(event2);
    }

    @Configuration
    static class Config {
        @Bean
        public ObjectReturningEvent1Listener first() {
            return new ObjectReturningEvent1Listener();
        }

        @Bean
        public VoidReturningEvent2Listener second() {
            return new VoidReturningEvent2Listener();
        }
    }
}
