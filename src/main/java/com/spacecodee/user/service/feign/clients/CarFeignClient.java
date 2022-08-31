package com.spacecodee.user.service.feign.clients;

import com.spacecodee.user.service.dto.CarEntityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "car-service", url = "localhost:8081", path = "/car")
public interface CarFeignClient {

    @PostMapping(value = "/add")
    CarEntityDto addCar(@RequestBody CarEntityDto carEntity);
}
