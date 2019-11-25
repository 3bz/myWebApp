import org.junit.Assert;
import org.junit.Test;

public class HandlerIntegrationTest {
    private UserStorage users = new World();
    private UserRepository repo = new UserRepository(users);
    GreetingHandler greetingHandler = new GreetingHandler(repo);
    UserHandler userHandler = new UserHandler(repo);

    @Test
    public void greetTwoUsers() {
        userHandler.addUser("Bob");
        String actual = userHandler.getUsers();

        Assert.assertEquals("Ryan, Bob", actual);
    }

}
