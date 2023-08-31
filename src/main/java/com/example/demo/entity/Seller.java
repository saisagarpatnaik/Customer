package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;
    @Column
    private String sellerName;
}
