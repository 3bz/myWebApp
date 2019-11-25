import com.sun.net.httpserver.HttpServer;

public class Main {

    public static void main(String[] args) {
        UserStorage serverWorld = new World();
        UserRepository userRepository = new UserRepository(serverWorld);

        HttpServer server = Server.createServer(userRepository);
        server.start();
        System.out.println(Messages.SERVER_ONLINE);
    }
}
