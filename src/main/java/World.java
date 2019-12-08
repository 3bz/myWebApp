import java.util.ArrayList;
import java.util.List;

public class World implements UserStorage {
    List<User> users = new ArrayList<>();

    public World() {
        initialiseWorldWithOwner();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void initialiseWorldWithOwner() {
        users.add(new User(Messages.WORLD_OWNER));
    }
}
