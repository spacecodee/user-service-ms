package com.spacecodee.user.service.service;

import com.spacecodee.user.service.entity.UserEntity;
import com.spacecodee.user.service.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;

    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public List<UserEntity> findAll() {
        return userEntityRepository.findAll();
    }

    public UserEntity getUserById(int id) {
        return userEntityRepository.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }
}
