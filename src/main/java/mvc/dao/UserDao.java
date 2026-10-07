package mvc.dao;

import mvc.entity.User;

import java.util.List;


public interface UserDao {

    List<User> findAll();

    void createUser(User user);

    User findById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);

}
