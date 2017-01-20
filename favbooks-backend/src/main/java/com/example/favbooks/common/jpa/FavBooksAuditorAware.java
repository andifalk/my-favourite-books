package com.example.favbooks.common.jpa;

import com.example.favbooks.user.entity.User;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by afa on 1/20/17.
 */
public class FavBooksAuditorAware implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {
        return null;
    }
}
