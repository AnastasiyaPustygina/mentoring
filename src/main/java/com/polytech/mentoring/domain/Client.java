package com.polytech.mentoring.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;

    // Возможно enum (1, 2, 3, 4, 5, магистратура1, магистратура2)
    @Column(name = "course", nullable = false)
    private String course;

    // Возможно enum
    @Column(name = "faculty", nullable = false)
    private String faculty;

    // Возможно enum
    @Column(name = "direction", nullable = false)
    private String direction;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "client_info", nullable = false)
    private String info;

}
