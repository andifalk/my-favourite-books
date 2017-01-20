package com.example.favbooks.common.transformer;

import com.example.favbooks.common.jpa.AbstractAuditableEntity;

import java.io.Serializable;

/**
 * Base transformer for JPA entities and DTOs.
 */
public interface DTOTransformer<E extends AbstractAuditableEntity, D extends Serializable> {

    D transformEntityToDTO(E entity);

    E transformDTOToEntity(D dto);

}
