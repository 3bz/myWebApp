import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main(String[] args) {
        HttpServer server = createServer();
        server.start();
    }

    public static HttpServer createServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/greeting", new GreetingHandler());
            server.setExecutor(null); // creates a default executor
            return server;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
