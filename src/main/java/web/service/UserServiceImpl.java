package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Transactional
    @Override
    public void edit(User user, int id) {
        userDAO.edit(user, id);
    }

    @Transactional
    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    List<User> users = new ArrayList<>();
    {
        users.add(new User("Ivan", "Petrov", 32));
        users.add(new User("Stepan", "Makarov", 31));
        users.add(new User("Petr", "Smit", 29));
        users.add(new User("Masha", "Petrova", 25));

    }
}