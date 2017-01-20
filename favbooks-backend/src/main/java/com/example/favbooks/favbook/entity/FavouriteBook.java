package com.example.favbooks.favbook.entity;

import com.example.favbooks.common.jpa.AbstractAuditableEntity;
import com.example.favbooks.user.entity.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * FavouriteBook entity.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class FavouriteBook extends AbstractAuditableEntity {

    /**
     *  The ISBN format:
     *  <ol>
     *      <li>prefix: three digit number, either '978' or '979'</li>
     *      <li>registration group: may contain up to 5 digits</li>
     *      <li>registrant: may contain up to 7 digits</li>
     *      <li>publication: may contain up to 6 digits</li>
     *      <li>check digit: contains 1 digit</li>
     *  </ol>
     *
     *  e.g. '978-0-571-08989-5' or '978 0 571 08989 5'
     */
    private static final String ISBN_REGEX = "^(978|979)[- ][0-9]{1,5}[- ][0-9]{1,7}[- ][0-9]{1,6}[- ][0-9]$";

    @Setter(value = AccessLevel.NONE)
    @NotNull
    @Version
    @Column(nullable = false)
    private Long version;

    @NonNull
    @NotNull
    private UUID identifier;

    @NonNull
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String title;

    @Size(min = 1, max = 2000)
    @Column(length = 2000)
    private String description;

    @Pattern(regexp = ISBN_REGEX)
    @Size(min = 11, max = 26)
    @Column(length = 26)
    private String isbn;

    @Size(max = 200)
    @Column(length = 200)
    private String orderUrl;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    private User owner;
}
