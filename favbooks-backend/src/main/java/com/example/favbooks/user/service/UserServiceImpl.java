package com.example.favbooks.user.service;

import com.example.favbooks.user.entity.User;
import com.example.favbooks.user.repository.UserRepository;
import com.example.favbooks.user.service.dto.UserDTO;
import com.example.favbooks.user.service.dto.UserDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Boundary service for managing {@link com.example.favbooks.user.entity.User users}.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final IdGenerator idGenerator;
    private final UserDTOTransformer userDTOTransformer;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, IdGenerator idGenerator, UserDTOTransformer userDTOTransformer) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
        this.userDTOTransformer = userDTOTransformer;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userDTOTransformer::transformEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userDTOTransformer.transformDTOToEntity(userDTO);
        if (userDTO.getIdentifier() == null) {
            user.setIdentifier(idGenerator.generateId());
        }
        return userDTOTransformer.transformEntityToDTO(
                userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userDTOTransformer.transformDTOToEntity(userDTO);
        return userDTOTransformer.transformEntityToDTO(
                userRepository.save(user));
    }

    @Override
    public UserDTO findUser(Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new EntityNotFoundException(String.format("No user found for id %s", id));
        } else {
            return userDTOTransformer.transformEntityToDTO(user);
        }
    }

    @Override
    public UserDTO findUserByIdentifier(UUID identifier) {
        User user = userRepository.findOneByIdentifier(identifier);
        if (user == null) {
            throw new EntityNotFoundException(String.format("No user found for identifier %s", identifier));
        } else {
            return userDTOTransformer.transformEntityToDTO(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(UserDTO userDTO) {
        userRepository.delete(userDTO.getId());
    }
}
