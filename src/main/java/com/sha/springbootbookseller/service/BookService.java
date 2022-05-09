package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.Book;
import com.sha.springbootbookseller.repository.IBooKRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private final IBooKRepository booKRepository;


    @Override
    public Book saveBook(Book book) {
        book.setCreateTime(LocalDateTime.now());
        return booKRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        booKRepository.deleteById(bookId);
    }

    @Override
    public List<Book> findAllBooks() {
        return booKRepository.findAll();
    }

}
