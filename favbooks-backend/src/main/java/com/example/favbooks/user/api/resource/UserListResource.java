package com.example.favbooks.user.api.resource;

import com.example.favbooks.user.api.UserRestController;
import com.example.favbooks.user.service.dto.UserDTO;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Resource for a list of {@link UserResource user resources}.
 */
public class UserListResource extends ResourceSupport {

    private List<UserResource> users;

    public UserListResource(Collection<UserDTO> userDTOs) {
        this.users = userDTOs
                        .stream()
                        .map(UserResource::new)
                        .collect(Collectors.toList());
        add(linkTo(methodOn(UserRestController.class).findAllUsers()).withSelfRel());
    }

    public List<UserResource> getUsers() {
        return users;
    }
}
