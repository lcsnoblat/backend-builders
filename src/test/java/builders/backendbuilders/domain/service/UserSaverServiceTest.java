package builders.backendbuilders.domain.service;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.ValidationException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserSaverServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserSaverService userSaverService;

    @Test
    public void whenCreateUserWithCpfNomeEmail_ThenCreateIsSuccess() {

        User mockedUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name("Lucas Noblat de Almeida")
                .cpf("16785588893")
                .email("lucasnoblat@gmail.com")
                .build();

        given(this.userRepository.save(any()))
                .willReturn(mockedUser);

        User newUser = User.builder()
                .name("Lucas Noblat de Almeida")
                .cpf("16785588893")
                .email("lucasnoblat@gmail.com")
                .build();

        User createdUser = userSaverService.save(newUser);

        assertEquals(createdUser.getCpf(), newUser.getCpf());
        assertEquals(createdUser.getEmail(), createdUser.getEmail());
    }

    @Test
    public void whenCreateUserWithoutCpfNomeEmail_ThenCreateIsError() {

        User newUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name("Lucas Noblat de Almeida")
                .cpf("16785588893")
                .email("lucasnoblat@gmail.com")
                .build();

        userSaverService.save(newUser);
    }
}