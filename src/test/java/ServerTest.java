import com.sun.net.httpserver.HttpServer;
import org.junit.Assert;
import org.junit.Test;

public class ServerTest {
    @Test
    public void testServerAddress() {
        World users = new World();
        UserRepository uRepo = new UserRepository(users);
        GreetingRepository gRepo = new GreetingRepository(users);
        HttpServer testServer = Server.createServer(uRepo, gRepo);
        int actual = testServer.getAddress().getPort();

        Assert.assertEquals(8080, actual);
    }
}
