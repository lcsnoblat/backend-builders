package builders.backendbuilders.view.handler;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.service.UserSaverService;
import builders.backendbuilders.view.controller.UserCollectionController;
import builders.backendbuilders.view.model.request.UserCreateRequest;
import builders.backendbuilders.view.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class UserCreatorHandler {
    private final UserSaverService userSaverService;

    @Autowired
    public UserCreatorHandler(UserSaverService userSaverService) {
        this.userSaverService = userSaverService;
    }

    public ResponseEntity create(UserCreateRequest userCreateRequest) {
        User create = User.builder()
                .cpf(userCreateRequest.getCpf())
                .name(userCreateRequest.getName())
                .telefone(userCreateRequest.getTelefone())
                .email(userCreateRequest.getEmail())
                .dataDeNascimento(userCreateRequest.getDataDeNascimento())
                .build();

        User created = userSaverService.save(create);

        String url = getUrl(created);
        URI uri = URI.create(url);

        UserResponse response = UserResponse.builder()
                .cpf(created.getCpf())
                .dataDeNascimento(created.getDataDeNascimento())
                .name(created.getName())
                .telefone(created.getTelefone())
                .email(created.getEmail())
                .uri(uri)
                .build();

        return ResponseEntity.created(uri)
                .body(response);
    }

    private String getUrl(User user) {

        StringBuilder sb = new StringBuilder();
        return sb.append(UserCollectionController.RESOURCE)
                .append("/")
                .append(user.getId())
                .toString();
    }
}
