package mvc.service;

import mvc.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User findById(Long id);

    void delete(Long id);

    void update(User user);
}
