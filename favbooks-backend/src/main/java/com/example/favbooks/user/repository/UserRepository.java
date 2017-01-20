package com.example.favbooks.user.repository;

import com.example.favbooks.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for {@link User}.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByIdentifier(UUID identifier);
}
