package com.example.favbooks;

import com.example.favbooks.favbook.repository.FavouriteBookRepository;
import com.example.favbooks.user.entity.User;
import com.example.favbooks.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Initializes some test data.
 */
@Component
public class FavBooksDataInitializer implements CommandLineRunner {

    @Autowired
    private FavouriteBookRepository favouriteBookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User(UUID.randomUUID(), "Hans",
                "Mustermann", "hans.mustermann@example.com");
        userRepository.save(user);

    }
}
