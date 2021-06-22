package builders.backendbuilders.domain.service;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserGetterServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserGetterService userGetterService;

    @Test
    void GetByIdShouldReturnRightUser() {
        User mockedUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name("Lucas Noblat de Almeida")
                .cpf("16785588893")
                .email("lucasnoblat@gmail.com")
                .build();

        given(this.userRepository.getById(any()))
                .willReturn(mockedUser);

        User newUser = User.builder()
                .name("Lucas Noblat de Almeida")
                .cpf("16785588893")
                .email("lucasnoblat@gmail.com")
                .build();

        User createdUser = userGetterService.get(newUser.getId());

        assertEquals(createdUser.getCpf(), newUser.getCpf());
        assertEquals(createdUser.getEmail(), createdUser.getEmail());
    }

    @Test
    void GetByIdShouldReturnNotFound() {
        User mockedUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name("Lucas Noblat de Almeida")
                .cpf("16785588893")
                .email("lucasnoblat@gmail.com")
                .build();

        User anotherMockedUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name("Lucas Noblat de Almeida")
                .cpf("222222222")
                .email("lucasnoblat@gmail.com")
                .build();

        given(this.userRepository.getById(mockedUser.getId()))
                .willReturn(mockedUser);
        given(this.userRepository.getById(any()))
                .willReturn(anotherMockedUser);

        User createdUser = userGetterService.get(UUID.randomUUID().toString());

        assertEquals(createdUser.getCpf(), anotherMockedUser.getCpf());
        assertEquals(createdUser.getEmail(), anotherMockedUser.getEmail());
    }
}