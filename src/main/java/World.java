import java.util.ArrayList;
import java.util.List;

public class World implements UserStorage {
    List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return users;
    }
}
