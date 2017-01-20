package com.example.favbooks.user.service.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * User value object.
 */
@Value
public class UserDTO implements Serializable {

    private Long id;

    private UUID identifier;

    private String firstName;

    private String lastName;

    private String email;

}
