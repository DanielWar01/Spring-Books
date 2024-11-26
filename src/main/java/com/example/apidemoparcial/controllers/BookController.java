package com.example.apidemoparcial.controllers;

import com.example.apidemoparcial.entities.Book;
import com.example.apidemoparcial.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> findAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> findBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            // Si el libro no se encuentra, enviar mensaje personalizado en formato JSON
            Map<String, String> response = new HashMap<>();
            response.put("message", "Book with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        // Si el libro se encuentra, enviar mensaje personalizado en formato JSON
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book found: " + book.getTitle() );
        return ResponseEntity.ok(response);
    }




}
