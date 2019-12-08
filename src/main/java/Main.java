import com.sun.net.httpserver.HttpServer;

public class Main {

    public static void main(String[] args) {
        UserStorage serverWorld = new World();
        UserRepository userRepo = new UserRepository(serverWorld);
        GreetingRepository greetingRepo = new GreetingRepository(serverWorld);

        HttpServer server = Server.createServer(userRepo, greetingRepo);
        server.start();
        System.out.println(Messages.SERVER_ONLINE);
    }
}
