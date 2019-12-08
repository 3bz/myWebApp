import java.util.List;

public class GreetingRepository {
    private UserStorage users;

    public GreetingRepository(UserStorage users){
        this.users = users;
    }

    public List<User> getUsers() {
        return users.getUsers();
    }
}
