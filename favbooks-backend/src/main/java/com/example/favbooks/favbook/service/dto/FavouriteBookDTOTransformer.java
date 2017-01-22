package com.example.favbooks.favbook.service.dto;

import com.example.favbooks.common.transformer.DTOTransformer;
import com.example.favbooks.favbook.entity.FavouriteBook;
import com.example.favbooks.user.entity.User;
import com.example.favbooks.user.service.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * Transformer between {@link FavouriteBook favourite book entity}
 * and {@link FavouriteBookDTO favourite book value object}.
 */
@Component
public class FavouriteBookDTOTransformer implements DTOTransformer<FavouriteBook, FavouriteBookDTO> {

    @Override
    public FavouriteBookDTO transformEntityToDTO(FavouriteBook entity) {
        return new FavouriteBookDTO(entity.getId(), entity.getIdentifier(),
                entity.getTitle(), entity.getDescription(), entity.getIsbn(), entity.getOrderUrl(), entity.getOwner());
    }

    @Override
    public FavouriteBook transformDTOToEntity(FavouriteBookDTO dto) {
        FavouriteBook favouriteBook = new FavouriteBook(dto.getIdentifier(), dto.getTitle(), dto.getOwner());
        favouriteBook.setDescription(dto.getDescription());
        favouriteBook.setIsbn(dto.getIsbn());
        favouriteBook.setOrderUrl(dto.getOrderUrl());
        return favouriteBook;
    }
}
