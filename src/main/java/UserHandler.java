import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class UserHandler implements HttpHandler {
    private World users;

    public UserHandler(World users) {
        this.users = users;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        handleRequest(exchange);
        handleResponse(exchange);
    }

    private void handleRequest(HttpExchange exchange) {
        if (exchange.getRequestMethod().equals("POST"))
            addUser(exchange.getRequestBody().toString());
    }

    private void handleResponse(HttpExchange exchange) {
    }

    public void addUser(String username) {
        if (!username.isEmpty()) {
            users.addUser(username);
        }
    }

    public String getUser() {
        return users.getUsers().get(0);
    }
}
