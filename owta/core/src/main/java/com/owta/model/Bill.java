package com.owta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "owta_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    Integer receiptNo;

    Double amount;

    String product;

    LocalDateTime date;
}
