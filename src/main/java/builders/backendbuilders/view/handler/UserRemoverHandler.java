package builders.backendbuilders.view.handler;

import builders.backendbuilders.domain.model.User;
import builders.backendbuilders.domain.service.UserGetterService;
import builders.backendbuilders.domain.service.UserRemoverService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserRemoverHandler {
    private final UserGetterService userGetterService;
    private final UserRemoverService userRemoverService;

    public UserRemoverHandler(UserGetterService userGetterService, UserRemoverService userRemoverService) {
        this.userGetterService = userGetterService;
        this.userRemoverService = userRemoverService;
    }

    public ResponseEntity remove(String id) {
        User user = userGetterService.get(id);
        userRemoverService.remove(user);
        return ResponseEntity.noContent().build();
    }
}
