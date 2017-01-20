package com.example.favbooks.user.service;

import com.example.favbooks.user.service.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Boundary service for managing {@link com.example.favbooks.user.entity.User users}.
 */
public interface UserService {
    List<UserDTO> findAllUsers();

    @Transactional
    UserDTO createUser(UserDTO userDTO);

    @Transactional
    UserDTO updateUser(UserDTO userDTO);

    UserDTO findUser(Long id);

    UserDTO findUserByIdentifier(UUID identifier);

    @Transactional
    void deleteUser(UserDTO userDTO);
}
