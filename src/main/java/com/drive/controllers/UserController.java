package com.drive.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.drive.models.UserModel;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    @ResponseBody
    public List<UserModel> holaMundo() {
        return List.of(
            new UserModel(1, "Isaac Dev"),
            new UserModel(2, "Anderson Dev"),
            new UserModel(3, "Daniela Dev")
        );
    }

}
