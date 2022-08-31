package com.spacecodee.user.service.service;

import com.spacecodee.user.service.dto.CarEntityDto;
import com.spacecodee.user.service.entity.UserEntity;
import com.spacecodee.user.service.repository.UserEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final RestTemplate restTemplate;

    public UserEntityService(UserEntityRepository userEntityRepository, RestTemplate restTemplate) {
        this.userEntityRepository = userEntityRepository;
        this.restTemplate = restTemplate;
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

    public List<CarEntityDto> getCarsByUserId(int id) {
        return this.restTemplate.getForObject("http://localhost:8081/car/by-user/" + id, List.class);
    }
}
