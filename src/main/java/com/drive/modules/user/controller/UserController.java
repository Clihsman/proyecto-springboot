package com.drive.modules.user.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.api.ApiController;
import com.drive.modules.user.model.User;
import com.drive.modules.user.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController extends ApiController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Object> get(HttpServletRequest request) {
        // se obtiene el id del usuario
        Integer userId = (Integer) request.getAttribute("userId");
        // se consulta el usuario en la base de datos
        Optional<User> user = userRepository.findById(userId);
        // se retorna el usuario
        return processResponse(user, "user not exists");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        // se consulta el usuario en la base de datos
        Optional<User> user = userRepository.findById(id);
        // se retorna el usuario
        return processResponse(user, "user not exists");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {

        if (!userRepository.existsById(id))
            return notFound("user not exists");
            
        userRepository.deleteById(id);

        return ResponseEntity.ok(null);
    }
}
