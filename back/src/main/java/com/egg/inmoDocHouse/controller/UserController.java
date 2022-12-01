package com.egg.inmoDocHouse.controller;


import com.egg.inmoDocHouse.entity.UserEntity;
import com.egg.inmoDocHouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> findAll() throws Exception {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<UserEntity> findByUserId(@PathVariable("userId") int userId) throws Exception {

        UserEntity userEntity = userService.findById(userId).orElse(null);

        if (userEntity.equals(null)) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}
