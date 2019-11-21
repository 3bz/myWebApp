import java.sql.Time;
import java.time.Instant;

public class Messages {
    public static final String METHOD_NOT_ALLOWED = "405: Method Not Allowed";

    public static String WELCOME_MESSAGE(String users) {
        return "Hello " + users + " - the time on the server is " + Time.from(Instant.now());
    }
}
