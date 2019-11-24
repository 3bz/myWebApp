import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Server {
    private static UserBase serverWorld;

    public static void main(String[] args) {
        serverWorld = new World();
        HttpServer server = createServer();
        server.start();
    }

    public static HttpServer createServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/greeting", new GreetingHandler(serverWorld));
            server.createContext("/users", new UserHandler(serverWorld));
            server.setExecutor(null); // creates a default executor
            return server;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
