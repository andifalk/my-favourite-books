package com.example.favbooks.favbook.repository;

import com.example.favbooks.favbook.entity.FavouriteBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link FavouriteBook favourite books}.
 */
public interface FavouriteBookRepository extends JpaRepository<FavouriteBook, Long> {
}
