package com.example.favbooks.common.jpa;

import com.example.favbooks.user.entity.User;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Abstract base class for auditable entities. Stores the audition values in persistent fields.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity extends AbstractPersistable<Long> {

    @ManyToOne
    @CreatedBy
    private User createdBy;

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @LastModifiedBy
    private User lastModifiedBy;

    @LastModifiedDate
    private Date lastModifiedAt;

}
