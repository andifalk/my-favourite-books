package com.example.favbooks.user.api;

import com.example.favbooks.user.api.resource.UserListResource;
import com.example.favbooks.user.api.resource.UserResource;
import com.example.favbooks.user.service.UserService;
import com.example.favbooks.user.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * RESTful api for users.
 */
@RestController
@RequestMapping(path = "/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserListResource> findAllUsers() {
        return ResponseEntity.ok(new UserListResource(userService.findAllUsers()));
    }

    @RequestMapping(path = "/{userid}", method = RequestMethod.GET)
    public ResponseEntity<?> findOneUser(@PathVariable("userid") UUID identifier) {
        UserDTO userDTO = userService.findUserByIdentifier(identifier);
        return ResponseEntity.ok(new UserResource(userDTO));
    }
}
