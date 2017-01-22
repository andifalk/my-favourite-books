package com.example.favbooks.favbook.api;

import com.example.favbooks.favbook.api.resource.CreateFavouriteBookResource;
import com.example.favbooks.favbook.api.resource.FavouriteBookListResource;
import com.example.favbooks.favbook.api.resource.FavouriteBookResource;
import com.example.favbooks.favbook.service.FavouriteBookService;
import com.example.favbooks.favbook.service.dto.FavouriteBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * RESTful api for {@link com.example.favbooks.favbook.entity.FavouriteBook favourite books}.
 */
@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FavouriteBookRestController {

    private final FavouriteBookService favouriteBookService;

    @Autowired
    public FavouriteBookRestController(FavouriteBookService favouriteBookService) {
        this.favouriteBookService = favouriteBookService;
    }

    @RequestMapping(path = "/{bookId}", method = RequestMethod.GET)
    public ResponseEntity<?> findBookByIdentifier(@PathVariable("bookId") UUID identifier) {
        FavouriteBookDTO favouriteBookDTO = favouriteBookService.findBookByIdentifier(identifier);
        return ResponseEntity.ok(new FavouriteBookResource(favouriteBookDTO));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<FavouriteBookListResource> findAllBooks() {
        return ResponseEntity.ok(new FavouriteBookListResource(
                favouriteBookService
                        .findAllBooks()
                        .stream()
                        .map(FavouriteBookResource::new)
                        .collect(Collectors.toList())));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FavouriteBookResource> createBook(
            @Valid @RequestBody CreateFavouriteBookResource createFavouriteBookResource) {
        FavouriteBookDTO persistentDto = favouriteBookService.createBook(new FavouriteBookDTO(null,
                createFavouriteBookResource.getIdentifier(), createFavouriteBookResource.getTitle(),
                createFavouriteBookResource.getDescription(), createFavouriteBookResource.getIsbn(),
                createFavouriteBookResource.getOrderUrl(), null));
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{bookId}")
                .buildAndExpand(persistentDto.getIdentifier()).toUri()).body(new FavouriteBookResource(persistentDto));
    }

    @RequestMapping(path = "/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable("bookId") UUID identifier) {
        favouriteBookService.deleteBook(identifier);
        return ResponseEntity.noContent().build();
    }
}
