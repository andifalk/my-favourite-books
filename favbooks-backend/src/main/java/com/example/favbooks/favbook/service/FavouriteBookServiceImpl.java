package com.example.favbooks.favbook.service;

import com.example.favbooks.favbook.entity.FavouriteBook;
import com.example.favbooks.favbook.repository.FavouriteBookRepository;
import com.example.favbooks.favbook.service.dto.FavouriteBookDTO;
import com.example.favbooks.favbook.service.dto.FavouriteBookDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service for managing {@link com.example.favbooks.favbook.entity.FavouriteBook favourite books}.
 */
@Transactional(readOnly = true)
@Service
public class FavouriteBookServiceImpl implements FavouriteBookService {

    private final FavouriteBookRepository favouriteBookRepository;

    private final FavouriteBookDTOTransformer favouriteBookDTOTransformer;

    @Autowired
    public FavouriteBookServiceImpl(FavouriteBookRepository favouriteBookRepository, FavouriteBookDTOTransformer favouriteBookDTOTransformer) {
        this.favouriteBookRepository = favouriteBookRepository;
        this.favouriteBookDTOTransformer = favouriteBookDTOTransformer;
    }

    @Override
    public FavouriteBookDTO findBookByIdentifier(UUID identifier) {
        FavouriteBook favouriteBook = favouriteBookRepository.findOneByIdentifier(identifier);
        if (favouriteBook == null) {
            throw new EntityNotFoundException(String.format("No book found for %s", identifier));
        }
        return favouriteBookDTOTransformer.transformEntityToDTO(favouriteBook);
    }

    @Override
    public List<FavouriteBookDTO> findAllBooks() {
        return favouriteBookRepository
                    .findAll()
                    .stream()
                    .map(favouriteBookDTOTransformer::transformEntityToDTO)
                    .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public FavouriteBookDTO createBook(FavouriteBookDTO dto) {
        return favouriteBookDTOTransformer.transformEntityToDTO(
                favouriteBookRepository.save(favouriteBookDTOTransformer.transformDTOToEntity(dto)));
    }

    @Override
    @Transactional
    public boolean deleteBook(UUID identifier) {
        return favouriteBookRepository.deleteOneByIdentifier(identifier) > 0;
    }
}
