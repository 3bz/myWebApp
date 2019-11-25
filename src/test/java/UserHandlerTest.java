import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserHandlerTest {
    private UserHandler testHandler;

    @Before
    public void init() {
        World users = new World();
        UserRepository repo = new UserRepository(users);
        testHandler = new UserHandler(repo);
    }

    @Test
    public void addNewUser() {
    }

    @Test
    public void addANewUser() {
        testHandler.addUser("World");
        String actual = testHandler.getUsers();

        Assert.assertEquals("World", actual);
    }

    @Test
    public void cannotChangeToEmptyName() {
        testHandler.addUser("  ");
        String actual = testHandler.getUsers();

        Assert.assertEquals("", actual);
    }
}
