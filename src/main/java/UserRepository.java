import java.util.List;

public class UserRepository {
    private UserStorage users;

    public UserRepository(UserStorage storage){
        users = storage;
    }

    public void addUser(User user){
        users.getUsers().add(user);
    }

    public void removeUser(User user){
        users.getUsers().remove(user);
    }

    public List<User> getUsers() {
        return users.getUsers();
    }
}
