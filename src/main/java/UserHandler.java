import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UserHandler implements HttpHandler {
    private UserRepository users;

    public UserHandler(UserRepository users) {
        this.users = users;
    }

    @Override
    public void handle(HttpExchange exchange) {
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
        if (!username.isEmpty() && !username.isBlank()) {
            if (isUserUnique(username))
                users.addUser(new User(username));
        }
    }

    private boolean isUserUnique(String username) {
        for (User aUser : users.getUsers()) {
            if (aUser.getName().equalsIgnoreCase(username))
                return false;
        }
        return true;
    }

    public String getUsers() {
        String listOfUsers = "";
        if (users.getUsers().size() > 0) {
            for (User aUser : users.getUsers()) {
                listOfUsers += aUser.getName() + "\n";
            }
            return listOfUsers.substring(0, listOfUsers.length() - 1);
        }
        return listOfUsers;
    }

    public void removeUser(String usersName) {
        if (usersName.equalsIgnoreCase(Messages.WORLD_OWNER)) {
            //set error message
            return;
        }
        for (User aUser : users.getUsers()) {
            if (aUser.getName().equalsIgnoreCase(usersName)) {
                users.removeUser(aUser);
                break;
            }
        }
    }
}
