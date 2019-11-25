import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.Instant;

public class GreetingHandlerTest {

    private GreetingHandler testHandler;

    @Before
    public void init() {
        World users = new World();
        UserRepository repo = new UserRepository(users);
        testHandler = new GreetingHandler(repo);
        testHandler.setWelcomeMessage();
    }

    @Test
    public void testUser() {
        String actual = testHandler.getUser().getName();

        Assert.assertEquals("Ryan", actual);
    }

    @Test
    public void testReturnCode() {
        int actual = testHandler.getReturnCode();

        Assert.assertEquals(200, actual);
    }

    @Test
    public void desiredResponse() {
        testHandler.setWelcomeMessage();
        String actual = testHandler.getResponse();
        String expected = "Hello Ryan - the time on the server is " + Time.from(Instant.now());

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
