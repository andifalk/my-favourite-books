package com.example.favbooks.user.api.resource;

import com.example.favbooks.user.api.UserRestController;
import com.example.favbooks.user.service.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Resource for {@link UserDTO user value object}.
 */
public class UserResource extends ResourceSupport {

    private final UserDTO userDTO;

    public UserResource(UserDTO userDTO) {
        this.userDTO = userDTO;

        add(ControllerLinkBuilder.linkTo(methodOn(UserRestController.class)
                .findOneUser(userDTO.getIdentifier())).withSelfRel());
    }

    @JsonProperty("id")
    public UUID getIdentifier() {
        return userDTO.getIdentifier();
    }

    @JsonProperty("firstname")
    public String getFirstName() {
        return userDTO.getFirstName();
    }

    @JsonProperty("lastname")
    public String getLastName() {
        return userDTO.getLastName();
    }

    @JsonProperty("email")
    public String getEmail() {
        return userDTO.getEmail();
    }
}
