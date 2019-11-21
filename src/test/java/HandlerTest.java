import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.Instant;

public class HandlerTest {

    private Handler testHandler;

    @Before
    public void init() {
        testHandler = new Handler();
        testHandler.setWelcomeMessage();
    }

    @Test
    public void testUser() {
        String actual = testHandler.getUser();

        Assert.assertEquals("Ryan", actual);
    }

    @Test
    public void testReturnCode() {
        int actual = testHandler.getReturnCode();

        Assert.assertEquals(200, actual);
    }

    @Test
    public void changeUser() {
        String user = "World";
        testHandler.addUser(user);
        String actual = testHandler.getUser();

        Assert.assertEquals("World", actual);
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

        Assert.assertEquals("Method Not Allowed", actual);
        Assert.assertEquals(405, actualRCode);
    }

}
