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
    public ResponseEntity<User> get(HttpServletRequest request) {
        // se obtiene el id del usuario
        Integer userId = (Integer) request.getAttribute("userId");
        // se consulta el usuario en la base de datos
        Optional<User> user = userRepository.findById(userId);
        // se retorna el usuario
        return ResponseEntity.of(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        // se consulta el usuario en la base de datos
        Optional<User> user = userRepository.findById(id);
        // se retorna el usuario
        return ResponseEntity.of(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
