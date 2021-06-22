package builders.backendbuilders.domain.service;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFinderService {

    private final UserRepository userRepository;

    @Autowired
    public UserFinderService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }
}
