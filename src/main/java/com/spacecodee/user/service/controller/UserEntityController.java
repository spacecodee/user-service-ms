package com.spacecodee.user.service.controller;

import com.spacecodee.user.service.dto.CarEntityDto;
import com.spacecodee.user.service.entity.UserEntity;
import com.spacecodee.user.service.service.UserEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserEntityController {

    private final UserEntityService userEntityService;

    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/list-all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(this.userEntityService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
        UserEntity user = this.userEntityService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/car/{id}")
    public ResponseEntity<List<CarEntityDto>> getCarsByUserId(@PathVariable int id) {
        List<CarEntityDto> carsByUserId = this.userEntityService.getCarsByUserId(id);
        if (carsByUserId == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(carsByUserId, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        return new ResponseEntity<>(this.userEntityService.save(userEntity), HttpStatus.OK);
    }
}
