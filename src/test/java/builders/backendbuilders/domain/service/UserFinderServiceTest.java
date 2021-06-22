package builders.backendbuilders.domain.service;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserFinderServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserFinderService userFinderService;

    @Test
    void findAll() {
        User mockedUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name("Lucas Noblat de Almeida")
                .cpf("222222222")
                .email("lucasnoblat@gmail.com")
                .build();

        List<User> users = new ArrayList<>() {};
        users.add(mockedUser);

        given(this.userRepository.findAll())
                .willReturn(users);

        List<User> createdUsers = userFinderService.findAll();

        assertTrue(createdUsers.contains(mockedUser));
        assertEquals(users.size(), createdUsers.size());
    }
}