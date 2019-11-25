import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserHandlerTest {
    World users = new World();
    UserRepository repo = new UserRepository(users);
    private UserHandler testHandler;

    @Before
    public void init() {
        testHandler = new UserHandler(repo);
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

    @Test
    public void addTwoUsers() {
        testHandler.addUser("Hello");
        testHandler.addUser("World");

        String actual = testHandler.getUsers();
        String expected = "Hello" +
                        "\nWorld";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void onlyAllowsUniqueUsers() {
        testHandler.addUser("World");
        testHandler.addUser("World");

        String actual = testHandler.getUsers();

        Assert.assertEquals("World", actual);
    }
}
