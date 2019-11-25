import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static HttpServer createServer(UserRepository userRepository) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/greeting", new GreetingHandler(userRepository));
            server.createContext("/users", new UserHandler(userRepository));
            server.setExecutor(null); // creates a default executor
            return server;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
