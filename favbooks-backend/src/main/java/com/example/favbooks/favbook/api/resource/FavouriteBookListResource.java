package com.example.favbooks.favbook.api.resource;

import com.example.favbooks.favbook.api.FavouriteBookRestController;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by afa on 1/22/17.
 */
public class FavouriteBookListResource extends ResourceSupport {

    private final List<FavouriteBookResource> favouriteBookResources;

    public FavouriteBookListResource(List<FavouriteBookResource> favouriteBookResources) {
        this.favouriteBookResources = favouriteBookResources;

        add(linkTo(methodOn(FavouriteBookRestController.class).findAllBooks()).withSelfRel());
    }

    public List<FavouriteBookResource> getFavouriteBooks() {
        return favouriteBookResources;
    }
}
