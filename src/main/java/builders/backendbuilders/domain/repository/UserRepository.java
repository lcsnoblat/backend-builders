package builders.backendbuilders.domain.repository;

import builders.backendbuilders.domain.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    User getById(String id);
    void delete(User user);
}
