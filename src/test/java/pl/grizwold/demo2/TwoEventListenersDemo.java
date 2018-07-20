package pl.grizwold.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.grizwold.listeners.VoidReturningEvent1Listener;
import pl.grizwold.model.Event1;

import java.util.function.Consumer;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TwoEventListenersDemo.Config.class)
public class TwoEventListenersDemo {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private VoidReturningEvent1Listener first;

    @Autowired
    private VoidReturningEvent1Listener second;

    @Mock
    private Consumer<Event1> firstMockConsumer;

    @Mock
    private Consumer<Event1> secondMockConsumer;

    @Test
    public void should_execute_listener_when_raising_single_event() throws Exception {
        first.consumer = firstMockConsumer;
        second.consumer = secondMockConsumer;

        Event1 event1 = new Event1();
        eventPublisher.publishEvent(event1);

        verify(firstMockConsumer).accept(event1);
        verify(secondMockConsumer).accept(event1);
    }

    @Configuration
    static class Config {
        @Bean
        public VoidReturningEvent1Listener first() {
            return new VoidReturningEvent1Listener();
        }

        @Bean
        public VoidReturningEvent1Listener second() {
            return new VoidReturningEvent1Listener();
        }
    }
}
