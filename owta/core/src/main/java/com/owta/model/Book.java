package com.owta.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "owta_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    User user;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "bill_id")
    Bill bill;

    LocalDateTime date;
}
