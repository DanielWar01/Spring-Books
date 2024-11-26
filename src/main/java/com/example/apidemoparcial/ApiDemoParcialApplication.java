package com.example.apidemoparcial;

import com.example.apidemoparcial.entities.Author;
import com.example.apidemoparcial.entities.Book;
import com.example.apidemoparcial.repositories.IBookRepository;
import com.example.apidemoparcial.services.AuthorService;
import com.example.apidemoparcial.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class ApiDemoParcialApplication {
    private final BookService bookService;
    private final AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(ApiDemoParcialApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertData() {
        return args -> {
            // Crear objetos Author para insertar
            Author author1 = new Author();
            author1.setName("John Doe");
            author1.setBirthDate(LocalDate.of(1985, 3, 10));
            author1.setCountry("USA");

            Author author2 = new Author();
            author2.setName("Jane Smith");
            author2.setBirthDate(LocalDate.of(1990, 8, 25));
            author2.setCountry("UK");

            // Guardar los autores en la base de datos
            authorService.saveAuthor(author1);
            authorService.saveAuthor(author2);

            // Crear objetos Book y asociarlos con autores
            Book book1 = new Book();
            book1.setTitle("Spring Boot for Beginners");
            book1.setISBN("9781234567890");
            book1.setPublicationDate(LocalDate.of(2020, 5, 20));
            book1.setLanguage("English");
            book1.setPages(300);
            book1.setPublisher("Spring Press");
            book1.setAuthor(author1);  // Asociar el autor al libro

            Book book2 = new Book();
            book2.setTitle("Advanced Java Programming");
            book2.setISBN("9791234567890");
            book2.setPublicationDate(LocalDate.of(2021, 7, 15));
            book2.setLanguage("English");
            book2.setPages(450);
            book2.setPublisher("Tech Books");
            book2.setAuthor(author2);  // Asociar el autor al libro

            // Guardar los libros en la base de datos
            bookService.saveBook(book1);
            bookService.saveBook(book2);

            System.out.println("Datos insertados correctamente");
        };
    }

}
