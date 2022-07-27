package web.DAO;
import web.models.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void add(User user);
    void delete(int id);
    void edit(User user, int id);
    User getById(int id);
}