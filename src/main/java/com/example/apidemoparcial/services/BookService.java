package com.example.apidemoparcial.services;

import com.example.apidemoparcial.entities.Book;
import com.example.apidemoparcial.repositories.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final IBookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).isPresent()?bookRepository.findById(id).get() : null;
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book){
        if (bookRepository.findById(id).isPresent()) {
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Long id){
        if (bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
        }
    }
}
