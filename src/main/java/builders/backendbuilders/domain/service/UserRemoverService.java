package builders.backendbuilders.domain.service;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRemoverService {

    private final UserRepository userRepository;

    public UserRemoverService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void remove(User user) {
        userRepository.delete(user);
    }
}
