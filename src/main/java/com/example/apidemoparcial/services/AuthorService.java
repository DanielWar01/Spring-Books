package com.example.apidemoparcial.services;

import com.example.apidemoparcial.entities.Author;
import com.example.apidemoparcial.repositories.IAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final IAuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).isPresent() ? authorRepository.findById(id).get() : null;
    }

    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author){
        return authorRepository.findById(id).isPresent() ? authorRepository.save(author) : null;
    }

    public void deleteAuthor(Long id){
        if (authorRepository.findById(id).isPresent()){
            authorRepository.deleteById(id);
        }
    }
}
