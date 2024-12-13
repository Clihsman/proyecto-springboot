package com.drive.modules.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.user.model.User;
import com.drive.modules.user.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> get() {
        // se consulta los usuarios en la base de datos
        List<User> users = userRepository.findAll();
        // se retorna la lista de usuarios
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(HttpServletRequest request, @PathVariable Integer id) {

        if (id.equals(0)) // si el id es cero se retorna el usuario actual
            id = (Integer) request.getAttribute("userId");

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
