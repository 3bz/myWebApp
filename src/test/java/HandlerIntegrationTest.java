import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.Instant;

public class HandlerIntegrationTest {
    private UserStorage users = new World();
    private UserRepository uRepo = new UserRepository(users);
    private GreetingRepository gRepo = new GreetingRepository(users);
    private GreetingHandler greetingHandler;
    private UserHandler userHandler;

    @Before
    public void init() {
        greetingHandler = new GreetingHandler(gRepo);
        userHandler = new UserHandler(uRepo);
    }

    @Test
    public void addUserToMyWorld() {
        userHandler.addUser("Bob");

        String actual = userHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER + "\nBob", actual);
    }

    @Test
    public void greetTwoUsers() {
        userHandler.addUser("Bob");
        greetingHandler.setWelcomeMessage();

        String actual = greetingHandler.getResponse();

        Assert.assertEquals("Hello " + Messages.WORLD_OWNER + " and Bob - the time on the server is " + Time.from(Instant.now()), actual);
    }

    @Test
    public void usesCommaSeparationForMoreThanTwoUsers() {
        userHandler.addUser("Bob");
        userHandler.addUser("Sue");
        greetingHandler.setWelcomeMessage();

        String actual = greetingHandler.getResponse();

        Assert.assertEquals("Hello " + Messages.WORLD_OWNER + ", Bob and Sue - the time on the server is " + Time.from(Instant.now()), actual);
    }
}
