package com.owta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonBackReference
    List<Book> book;

    boolean status;
}
