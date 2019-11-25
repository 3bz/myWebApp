import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class UserHandler implements HttpHandler {
    private UserRepository users;

    public UserHandler(UserRepository users) {
        this.users = users;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        handleRequest(exchange);
        handleResponse(exchange);
    }

    private void handleRequest(HttpExchange exchange) {
        if (exchange.getRequestMethod().equals("POST")) {
            String userToAdd = exchange.getRequestBody().toString();
            addUser(userToAdd);
        }
    }

    private void handleResponse(HttpExchange exchange) {
    }

    public void addUser(String username) {
        if (!username.isEmpty() && !username.isBlank())
            users.addUser(new User(username));
    }

    public String getUsers() {
        String listOfUsers = "";
        if (users.getUsers().size() > 0) {
            for (User aUser : users.getUsers()) {
                listOfUsers += aUser.getName() + ", ";
            }
            return listOfUsers.substring(0, listOfUsers.length() - 2);
        }
        return listOfUsers;
    }
}
