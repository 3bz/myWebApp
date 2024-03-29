import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class GreetingHandler implements HttpHandler {

    private GreetingRepository storage;

    private int returnCode;
    private String response;

    public GreetingHandler(GreetingRepository users) {
        storage = users;
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
        response = Messages.WELCOME_MESSAGE(getUsers());
        returnCode = 200;
    }

    public void setErrorMessage() {
        response = Messages.METHOD_NOT_ALLOWED;
        returnCode = 405;
    }

    public String getUsers() {
        String namesOfUsers = "";
        for (int i = 0; i < storage.getUsers().size(); i ++) {
            namesOfUsers += storage.getUsers().get(i).getName();
            if (i + 2 < storage.getUsers().size())
                namesOfUsers += ", ";
            if (i + 2 == storage.getUsers().size())
                namesOfUsers += " and ";
        }
        return namesOfUsers;
    }

    String getResponse() {
        return response;
    }

    int getReturnCode() {
        return returnCode;
    }
}
