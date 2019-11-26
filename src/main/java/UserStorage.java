import java.util.List;

public interface UserStorage {
    List<User> getUsers();
    void initialiseWorldWithOwner();
}
