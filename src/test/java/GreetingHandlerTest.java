import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.Instant;

public class GreetingHandlerTest {

    private World users = new World();
    private UserRepository repo = new UserRepository(users);
    private GreetingHandler testHandler;

    @Before
    public void init() {
        testHandler = new GreetingHandler(repo);
        testHandler.setWelcomeMessage();
    }

    @Test
    public void testUser() {
        String actual = testHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER, actual);
    }

    @Test
    public void testReturnCode() {
        int actual = testHandler.getReturnCode();

        Assert.assertEquals(200, actual);
    }

    @Test
    public void greetedWithNameAndTime() {
        String actual = testHandler.getResponse();
        String expected = "Hello " + Messages.WORLD_OWNER + " - the time on the server is " + Time.from(Instant.now());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void errorMessageResponse() {
        testHandler.setErrorMessage();
        String actual = testHandler.getResponse();
        int actualRCode = testHandler.getReturnCode();

        Assert.assertEquals("405: Method Not Allowed", actual);
        Assert.assertEquals(405, actualRCode);
    }

}
