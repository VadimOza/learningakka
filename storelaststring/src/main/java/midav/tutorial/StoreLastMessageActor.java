package midav.tutorial;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StoreLastMessageActor extends AbstractActor {

    protected String lastMessage = "";

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(String.class, message -> {
                    log.info("Received message {}", message);
                    lastMessage = message;
                })
                .matchAny(o -> log.info("Received unknown message {}", o))
                .build();
    }
}
