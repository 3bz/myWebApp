import java.util.ArrayList;
import java.util.List;

public class World implements UserBase {
    List<String> users = new ArrayList<>();

    @Override
    public void addUser(String user) {
        users.add(user);
    }

    @Override
    public void removeUser(String user) {
        users.remove(user);
    }

    public List<String> getUsers() {
        return users;
    }
}
