package com.owta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
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

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "bill")
    @JsonBackReference
    Book book;
}
