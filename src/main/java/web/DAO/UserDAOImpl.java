package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void edit(User user, int id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}