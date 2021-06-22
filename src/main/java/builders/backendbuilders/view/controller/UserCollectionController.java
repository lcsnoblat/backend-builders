package builders.backendbuilders.view.controller;

import builders.backendbuilders.view.handler.UserCreatorHandler;
import builders.backendbuilders.view.handler.UserFinderHandler;
import builders.backendbuilders.view.model.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserCollectionController.RESOURCE)
public class UserCollectionController {

    public static final String RESOURCE = "/user";

    private final UserFinderHandler userFinderHandler;
    private final UserCreatorHandler creatorHandler;

    @Autowired
    public UserCollectionController(UserFinderHandler userFinderHandler, UserCreatorHandler creatorHandler) {
        this.userFinderHandler = userFinderHandler;
        this.creatorHandler = creatorHandler;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> findAll() {
        return userFinderHandler.find();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> create(@RequestBody UserCreateRequest request) {
        return creatorHandler.create(request);
    }
}
