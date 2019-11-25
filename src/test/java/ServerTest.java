import com.sun.net.httpserver.HttpServer;
import org.junit.Assert;
import org.junit.Test;

public class ServerTest {
    @Test
    public void testServerAddress() {
        World users = new World();
        UserRepository repo = new UserRepository(users);
        HttpServer testServer = Server.createServer(repo);
        int actual = testServer.getAddress().getPort();

        Assert.assertEquals(8080, actual);
    }
}
