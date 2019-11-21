import org.junit.Assert;
import org.junit.Test;

public class ServerTest {
    @Test
    public void testServerAddress() {
        Server testServer = new Server();
        int actual = testServer.createServer().getAddress().getPort();

        Assert.assertEquals(8080, actual);
    }
}
