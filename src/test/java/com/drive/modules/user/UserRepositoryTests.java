package com.drive.modules.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.drive.modules.user.model.User;
import com.drive.modules.user.repository.UserRepository;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    private User user;

    @BeforeEach
    private void setup() {
        // se crea el usuario de prueba
        user = User.builder()
                .firstName("firstName test")
                .middleName("middleName test")
                .lastName("lastName test")
                .secondLastName("secondLastName test")
                .email("email@test")
                .address("address test")
                .phone("phone test")
                .password("password test")
                .build();
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @DisplayName("Test creación de usuario")
    @Test
    public void testSaveUser() {
        // Se guarda el usuario de prueba en la base de datos
        User savedUser = repository.save(user);

        // Se valida que se guardó correctamente el usuario en la base de datos
        assertNotNull(savedUser, "El usuario creado no puede ser null");
        assertNotNull(savedUser.getId(), "El ID del usuario guardado no debe ser null");
        assertTrue(savedUser.getId() > 0, "El ID del usuario guardado debe ser mayor que 0");

        // Comparar campos individuales
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        assertEquals(user.getMiddleName(), savedUser.getMiddleName());
        assertEquals(user.getLastName(), savedUser.getLastName());
        assertEquals(user.getSecondLastName(), savedUser.getSecondLastName());
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getAddress(), savedUser.getAddress());
        assertEquals(user.getPhone(), savedUser.getPhone());
        assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @DisplayName("Test actualizar usuario por id")
    @Test
    public void testUpdateUserById() {
        // when
        User savedUser = repository.save(user);
        savedUser.setFirstName("firstName update");
        savedUser.setMiddleName("middleName update");
        savedUser.setLastName("lastName update");
        savedUser.setSecondLastName("secondLastName update");
        savedUser.setEmail("email@update");
        savedUser.setAddress("address update");
        savedUser.setPhone("phone update");
        savedUser.setPassword("password update");

        final User updatedUser = repository.save(savedUser);

        // then
        // Verificar que el ID no ha cambiado
        assertEquals(savedUser.getId(), updatedUser.getId(),
                "El ID del usuario no debe cambiar después de una actualización");
        // Verificar que los datos del usuario se actualizaron
        assertAll(
                () -> assertEquals(savedUser.getId(), updatedUser.getId()),
                () -> assertEquals(savedUser.getFirstName(), updatedUser.getFirstName()),
                () -> assertEquals(savedUser.getMiddleName(), updatedUser.getMiddleName()),
                () -> assertEquals(savedUser.getLastName(), updatedUser.getLastName()),
                () -> assertEquals(savedUser.getSecondLastName(), updatedUser.getSecondLastName()),
                () -> assertEquals(savedUser.getEmail(), updatedUser.getEmail()),
                () -> assertEquals(savedUser.getAddress(), updatedUser.getAddress()),
                () -> assertEquals(savedUser.getPhone(), updatedUser.getPhone()),
                () -> assertEquals(savedUser.getPassword(), updatedUser.getPassword()));
    }

    @DisplayName("Test eliminar usuario por id")
    @Test
    public void testDeleteUserById() {
        // Guardar el usuario
        User savedUser = repository.save(user);
        Integer userId = savedUser.getId();

        // Verificar que el usuario existe
        Optional<User> searchedUser = repository.findById(userId);
        assertTrue(searchedUser.isPresent(), "El usuario debería existir antes de ser eliminado");

        // Eliminar el usuario
        repository.delete(savedUser);

        // Verificar que el usuario ya no existe
        Optional<User> deletedUser = repository.findById(userId);
        assertFalse(deletedUser.isPresent(), "El usuario no debería existir después de ser eliminado");
    }

    @DisplayName("Test obtener todos los usuarios")
    @Test
    public void testGetAllUsers() {
        // Se guarda el usuario de prueba
        repository.save(user);

        // Se obtiene todos los usuarios del repositorio
        List<User> users = repository.findAll();

        // Validación
        assertNotNull(users, "La lista de usuarios no puede ser null");
        assertEquals(1, users.size(), "Debe haber exactemente un usuario");
        assertEquals(users.get(0), user, "El usuario de la lista debe ser igual al usuario guardado");
    }

    @DisplayName("Test obtener usuario por id")
    @Test
    public void testGetUserById() {
        // Se guarda el usuario
        User savedUser = repository.save(user);

        // Se busca el usuario por el id
        Optional<User> user = repository.findById(savedUser.getId());

        // Validación
        assertTrue(user.isPresent(), "El usuario debería estar presente al buscar por id");
    }

    @DisplayName("Test obtener usuario por correo")
    @Test
    public void testGetUserByEmail() {
        // Se guarda el usuario
        repository.save(user);

        // Se busca el usuario por el correo
        Optional<User> user = repository.findByEmail("email@test");

        // Validación
        assertTrue(user.isPresent(), "El usuario debería estar presente al buscar por email");
        assertEquals(user.get().getEmail(), "email@test", "El email del usuario debería coincidir");
    }

}
