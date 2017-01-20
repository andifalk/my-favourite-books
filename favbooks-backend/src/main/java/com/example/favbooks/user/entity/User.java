package com.example.favbooks.user.entity;

import com.example.favbooks.common.jpa.AbstractAuditableEntity;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.UUID;

/**
 * User entity.
 */
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class User extends AbstractAuditableEntity implements UserDetails {

    @Setter(value = AccessLevel.NONE)
    @NotNull
    @Version
    @Column(nullable = false)
    private Long version;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private UUID identifier;

    @NonNull
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String firstName;

    @NonNull
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String lastName;

    @NonNull
    @NotNull
    @Email
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String email;

    /**
     * Gets the full name of user.
     *
     * @return the full name
     */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return "n/a";
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
