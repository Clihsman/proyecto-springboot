package com.drive.modules.user.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.drive.modules.auth.model.Token;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String secondLastName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = true)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Token> tokens;
}

/*
 * CREATE TABLE `asesor` (
 * `direccion_ase` VARCHAR(250) NOT NULL COLLATE 'utf8mb4_spanish_ci',
 * `telefono_ase` VARCHAR(80) NOT NULL COLLATE 'utf8mb4_spanish_ci',
 * `correo_ase` VARCHAR(150) NOT NULL COLLATE 'utf8mb4_spanish_ci',
 * `contraseha` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_spanish_ci',
 * `nombre_usuario` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_spanish_ci',
 * `tipouser` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_spanish_ci',
 * `id_sucursal` INT(11) NULL DEFAULT NULL,
 * PRIMARY KEY (`asesor_id`) USING BTREE,
 * INDEX `id_sucursal` (`id_sucursal`) USING BTREE,
 * CONSTRAINT `asesor_ibfk_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal`
 * (`id_sucursal`) ON UPDATE RESTRICT ON DELETE RESTRICT,
 * CONSTRAINT `tipouser` CHECK (`tipouser` in ('Empleado','Administrador'))
 * )
 * COLLATE='utf8mb4_spanish_ci'
 * ENGINE=InnoDB
 * ;
 */