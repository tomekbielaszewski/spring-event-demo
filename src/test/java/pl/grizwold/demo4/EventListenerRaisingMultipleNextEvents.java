package pl.grizwold.demo4;

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
import pl.grizwold.listeners.VoidReturningEvent3Listener;
import pl.grizwold.model.Event1;
import pl.grizwold.model.Event2;
import pl.grizwold.model.Event3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventListenerRaisingMultipleNextEvents.Config.class)
public class EventListenerRaisingMultipleNextEvents {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private ObjectReturningEvent1Listener first;

    @Autowired
    private VoidReturningEvent2Listener second;

    @Autowired
    private VoidReturningEvent3Listener third;

    @Mock
    private Consumer<Event1> firstMockConsumer;

    @Mock
    private Consumer<Event2> secondMockConsumer;

    @Mock
    private Consumer<Event3> thirdMockConsumer;

    @Test
    public void should_execute_two_different_listeners_after_returning_list_of_events_from_first_listener() throws Exception {
        Event1 event1 = new Event1();
        Event2 event2 = new Event2();
        Event3 event3 = new Event3();

        List eventList = new ArrayList();
        eventList.add(event2);
        eventList.add(event3);

        first.consumer = firstMockConsumer;
        first.supplier = () -> eventList;

        second.consumer = secondMockConsumer;
        third.consumer = thirdMockConsumer;

        eventPublisher.publishEvent(event1);

        verify(firstMockConsumer).accept(event1);
        verify(secondMockConsumer).accept(event2);
        verify(thirdMockConsumer).accept(event3);
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

        @Bean
        public VoidReturningEvent3Listener third() {
            return new VoidReturningEvent3Listener();
        }
    }
}
