package midav.tutorial;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import midav.tutorial.StoreLastMessageActor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoreLastActorTest {

    private ActorSystem system = ActorSystem.create();

    private final String firstMessage = "hello";
    private final String secondMessage = "world";

    @Test
    public void storeLastMessageTest() {

        TestActorRef<StoreLastMessageActor> actoreRef = TestActorRef.create(system, Props.create(StoreLastMessageActor.class));
        actoreRef.tell(firstMessage, actoreRef);
        StoreLastMessageActor actor = actoreRef.underlyingActor();
        assertEquals(actor.lastMessage, firstMessage);
        actoreRef.tell(secondMessage, actoreRef);
        assertEquals(actor.lastMessage, secondMessage);
    }

}
