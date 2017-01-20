package com.example.favbooks.favbook.service;

import com.example.favbooks.user.entity.User;
import lombok.Value;

import java.util.UUID;

/**
 * Favourite book value object.
 */
@Value
public class FavouriteBookDTO {

    private Long id;

    private UUID identifier;

    private String title;

    private String description;

    private String isbn;

    private User owner;
}
