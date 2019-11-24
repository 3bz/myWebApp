import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserHandlerTest {
    private UserHandler testHandler;

    @Before
    public void init() {
        testHandler = new UserHandler(new World());
    }

    @Test
    public void addNewUser() {
    }

    @Test
    public void addANewUser() {
        testHandler.addUser("World");
        String actual = testHandler.getUser();

        Assert.assertEquals("World", actual);
    }

    @Test
    public void cannotChangeToEmptyName() {
        testHandler.addUser("");
        String actual = testHandler.getUser();

        Assert.assertEquals("Ryan", actual);
    }
}
