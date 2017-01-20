package com.example.favbooks.user.service.dto;

import com.example.favbooks.common.transformer.DTOTransformer;
import com.example.favbooks.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * Transformer between {@link User user entity} and {@link UserDTO user value object}.
 */
@Component
public class UserDTOTransformer implements DTOTransformer<User, UserDTO> {

    @Override
    public UserDTO transformEntityToDTO(User entity) {
        return new UserDTO(entity.getId(), entity.getIdentifier(),
                entity.getFirstName(), entity.getLastName(), entity.getEmail());
    }

    @Override
    public User transformDTOToEntity(UserDTO dto) {
        return new User(dto.getIdentifier(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
}
