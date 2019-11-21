import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Time;
import java.time.Instant;

public class Handler implements HttpHandler {

    private int returnCode;
    private String response;
    private String user = "Ryan";

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
        response = "Hello " + user + " - the time on the server is " + Time.from(Instant.now());
        returnCode = 200;
    }

    public void setErrorMessage() {
        response = "Method Not Allowed";
        returnCode = 405;
    }

    public void addUser(String username) {
        user = username;
    }

    public String getUser() {
        return user;
    }

    String getResponse() {
        return response;
    }

    int getReturnCode() {
        return returnCode;
    }
}
