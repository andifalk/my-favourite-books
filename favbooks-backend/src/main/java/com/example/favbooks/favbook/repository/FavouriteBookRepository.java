package com.example.favbooks.favbook.repository;

import com.example.favbooks.favbook.entity.FavouriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * Repository for {@link FavouriteBook favourite books}.
 */
public interface FavouriteBookRepository extends JpaRepository<FavouriteBook, Long> {

    FavouriteBook findOneByIdentifier(UUID identifier);

    @Modifying
    @Query("delete from FavouriteBook book where book.identifier = :identifier")
    Long deleteOneByIdentifier(@Param("identifier") UUID identifier);
}
