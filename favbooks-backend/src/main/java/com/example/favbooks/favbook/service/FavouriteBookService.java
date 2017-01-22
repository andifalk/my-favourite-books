package com.example.favbooks.favbook.service;

import com.example.favbooks.favbook.service.dto.FavouriteBookDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Service for managing {@link com.example.favbooks.favbook.entity.FavouriteBook favourite books}.
 */
public interface FavouriteBookService {
    FavouriteBookDTO findBookByIdentifier(UUID identifier);

    List<FavouriteBookDTO> findAllBooks();

    @Transactional
    FavouriteBookDTO createBook(FavouriteBookDTO dto);

    @Transactional
    boolean deleteBook(UUID identifier);
}
