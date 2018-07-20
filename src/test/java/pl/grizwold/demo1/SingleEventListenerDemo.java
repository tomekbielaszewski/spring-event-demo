package pl.grizwold.demo1;

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
@ContextConfiguration(classes = SingleEventListenerDemo.Config.class)
public class SingleEventListenerDemo {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private VoidReturningEvent1Listener eventListener;

    @Mock
    private Consumer<Event1> mockConsumer;

    @Test
    public void should_execute_listener_when_raising_single_event() throws Exception {
        Event1 event1 = new Event1();
        eventListener.consumer = mockConsumer;

        eventPublisher.publishEvent(event1);

        verify(mockConsumer).accept(event1);
    }

    @Configuration
    static class Config {
        @Bean
        public VoidReturningEvent1Listener voidReturningEventListener() {
            return new VoidReturningEvent1Listener();
        }
    }
}