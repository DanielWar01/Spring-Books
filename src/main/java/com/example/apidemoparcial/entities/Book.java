package com.example.apidemoparcial.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String ISBN;
    private LocalDate publicationDate;
    private String language;
    private Integer pages;
    private String publisher;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
