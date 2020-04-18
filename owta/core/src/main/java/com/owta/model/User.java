package com.owta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "owta_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String role;

    String name;

    String password;

    String email;

    LocalDate dob;
}
