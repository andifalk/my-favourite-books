package com.example.favbooks.favbook.service.dto;

import com.example.favbooks.user.entity.User;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * Favourite book value object.
 */
@Value
public class FavouriteBookDTO implements Serializable {

    private Long id;

    private UUID identifier;

    private String title;

    private String description;

    private String isbn;

    private String orderUrl;

    private User owner;
}
