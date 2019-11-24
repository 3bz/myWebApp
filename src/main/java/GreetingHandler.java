import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class GreetingHandler implements HttpHandler {

    private World users;
    private int returnCode;
    private String response;

    public GreetingHandler(World users) {
        this.users = users;
        users.addUser("Ryan");
    }

    @Override
    public void handle(HttpExchange exchange) {
        handleRequest(exchange);
        handleResponse(exchange);
    }

    private void handleRequest(HttpExchange exchange) {
        if (exchange.getRequestMethod().equals("GET"))
            setWelcomeMessage();
        else
            setErrorMessage();
    }

    private void handleResponse(HttpExchange exchange) {
        try {
            exchange.sendResponseHeaders(returnCode, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setWelcomeMessage() {
        response = Messages.WELCOME_MESSAGE(users.getUsers().get(0));
        returnCode = 200;
    }

    public void setErrorMessage() {
        response = Messages.METHOD_NOT_ALLOWED;
        returnCode = 405;
    }

    public String getUser() {
        return users.getUsers().get(0);
    }

    String getResponse() {
        return response;
    }

    int getReturnCode() {
        return returnCode;
    }
}
