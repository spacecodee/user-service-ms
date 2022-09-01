package com.spacecodee.user.service.service;

import com.spacecodee.user.service.dto.CarEntityDto;
import com.spacecodee.user.service.entity.UserEntity;
import com.spacecodee.user.service.feign.clients.CarFeignClient;
import com.spacecodee.user.service.repository.UserEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final RestTemplate restTemplate;
    private final CarFeignClient carFeignClient;

    public UserEntityService(UserEntityRepository userEntityRepository, RestTemplate restTemplate,
                             CarFeignClient carFeignClient) {
        this.userEntityRepository = userEntityRepository;
        this.restTemplate = restTemplate;
        this.carFeignClient = carFeignClient;
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
        return this.restTemplate.getForObject("http://localhost:car-service/car/by-user/" + id, List.class);
    }

    public CarEntityDto addCar(int id, CarEntityDto carEntityDto) {
        carEntityDto.setCarUserId(id);
        return this.carFeignClient.addCar(carEntityDto);
    }
}
