package builders.backendbuilders.view.controller;

import builders.backendbuilders.view.handler.UserGetterHandler;
import builders.backendbuilders.view.handler.UserRemoverHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserMemberController.RESOURCE)
public class UserMemberController {

    public static final String RESOURCE = UserCollectionController.RESOURCE + "/{id}";

    private final UserGetterHandler userGetterHandler;
    private final UserRemoverHandler userRemoverHandler;

    @Autowired
    public UserMemberController(UserGetterHandler userGetterHandler, UserRemoverHandler userRemoverHandler) {
        this.userGetterHandler = userGetterHandler;
        this.userRemoverHandler = userRemoverHandler;
    }

    @GetMapping
    public ResponseEntity get(@PathVariable String id) {
        return userGetterHandler.get(id);
    }

    @PostMapping
    public ResponseEntity remove(@PathVariable String id) {
        return userRemoverHandler.remove(id);
    }

}
