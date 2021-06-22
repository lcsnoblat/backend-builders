package builders.backendbuilders.view.handler;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.service.UserGetterService;
import builders.backendbuilders.view.controller.UserCollectionController;
import builders.backendbuilders.view.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserGetterHandler {

    private final UserGetterService userGetterService;

    @Autowired
    public UserGetterHandler(UserGetterService userGetterService) {
        this.userGetterService = userGetterService;
    }

    public ResponseEntity get(String id) {

        User user = userGetterService.get(id);

        UserResponse response = UserResponse.builder()
                .cpf(user.getCpf())
                .dataDeNascimento(user.getDataDeNascimento())
                .name(user.getName())
                .telefone(user.getTelefone())
                .email(user.getEmail())
                .build();

        return ResponseEntity.ok(response);
    }

    private String getUrl(User user) {

        StringBuilder sb = new StringBuilder();
        return sb.append(UserCollectionController.RESOURCE)
                .append("/")
                .append(user.getId())
                .toString();
    }
}
