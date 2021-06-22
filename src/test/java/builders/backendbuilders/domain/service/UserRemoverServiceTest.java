package builders.backendbuilders.domain.service;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

class UserRemoverServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserRemoverService userRemoverService;

    @Test
    void remove() {
    }
}