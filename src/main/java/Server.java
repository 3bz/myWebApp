import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static HttpServer createServer(UserRepository userRepo, GreetingRepository greetingRepo) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/greeting", new GreetingHandler(greetingRepo));
            server.createContext("/users", new UserHandler(userRepo));
            server.setExecutor(null); // creates a default executor
            return server;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
