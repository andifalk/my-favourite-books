package com.example.favbooks.favbook.api.resource;

import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by afa on 1/22/17.
 */
@NoArgsConstructor
@Value
public class CreateFavouriteBookResource {

    private UUID identifier = null;

    @NotNull
    private String title = "";

    private String description = "";

    private String isbn = "";

    private String orderUrl = "";
}
