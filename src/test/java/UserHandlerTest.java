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
        testHandler.addUser("Bob");
        String actual = testHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER + "\nBob", actual);
    }

    @Test
    public void cannotAddUserWithEmptyName() {
        testHandler.addUser("  ");
        String actual = testHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER, actual);
    }

    @Test
    public void addTwoUsers() {
        testHandler.addUser("Hello");
        testHandler.addUser("World");

        String actual = testHandler.getUsers();
        String expected = (Messages.WORLD_OWNER +
                        "\nHello" +
                        "\nWorld");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void onlyAllowsUniqueUsers() {
        testHandler.addUser("Bob");
        testHandler.addUser("Bob");

        String actual = testHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER + "\nBob", actual);
    }

    @Test
    public void removeUserFromWorld() {
        testHandler.addUser("Bob");
        testHandler.removeUser("Bob");
        String actual = testHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER, actual);
    }

    @Test
    public void cannotRemoveWorldOwner() {
        testHandler.addUser(Messages.WORLD_OWNER);
        testHandler.removeUser(Messages.WORLD_OWNER);

        String actual = testHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER, actual);
    }

    @Test
    public void changeNameOfUser() {
        testHandler.addUser("Sue");
        testHandler.updateUser("Sue", "Dave");

        String actual = testHandler.getUsers();

        Assert.assertEquals(Messages.WORLD_OWNER + "\nDave", actual);
    }
}
