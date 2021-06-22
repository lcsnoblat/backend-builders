package builders.backendbuilders.view.handler;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.service.UserFinderService;
import builders.backendbuilders.view.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFinderHandler {

    private final UserFinderService userFinderService;

    @Autowired
    public UserFinderHandler(UserFinderService userFinderService) {
        this.userFinderService = userFinderService;
    }

    public ResponseEntity find() {
        List<User> users = userFinderService.findAll();

        List<UserResponse> response = users.stream()
                .map(user -> {
                    UserResponse r = UserResponse.builder()
                            .cpf(user.getCpf())
                            .dataDeNascimento(user.getDataDeNascimento())
                            .name(user.getName())
                            .telefone(user.getTelefone())
                            .email(user.getEmail())
                            .build();

                    return r;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
