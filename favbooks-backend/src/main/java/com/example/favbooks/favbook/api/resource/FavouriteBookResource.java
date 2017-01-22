package com.example.favbooks.favbook.api.resource;

import com.example.favbooks.favbook.repository.FavouriteBookRepository;
import com.example.favbooks.favbook.service.dto.FavouriteBookDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Resource for {@link FavouriteBookDTO}.
 */
public class FavouriteBookResource extends ResourceSupport {

    private final FavouriteBookDTO favouriteBookDTO;

    public FavouriteBookResource(FavouriteBookDTO favouriteBookDTO) {
        this.favouriteBookDTO = favouriteBookDTO;

        add(linkTo(methodOn(FavouriteBookRepository.class)
                .findOneByIdentifier(favouriteBookDTO.getIdentifier())).withSelfRel());

    }

    @JsonProperty("id")
    public UUID getIdentifier() {
        return favouriteBookDTO.getIdentifier();
    }

    public String getTitle() {
        return favouriteBookDTO.getTitle();
    }

    public String getDescription() {
        return favouriteBookDTO.getDescription();
    }

    public String getIsbn() {
        return favouriteBookDTO.getIsbn();
    }

    public String getOrderUrl() {
        return favouriteBookDTO.getOrderUrl();
    }

    public UUID getOwnerId() {
        return favouriteBookDTO.getOwner().getIdentifier();
    }

    public String getOwner() {
        return favouriteBookDTO.getOwner().getFullName();
    }

}
