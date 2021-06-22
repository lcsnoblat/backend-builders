package builders.backendbuilders.domain.service;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGetterService {

    private final UserRepository userRepository;

    @Autowired
    public UserGetterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(String id) {
        return userRepository.getById(id);
    }
}
