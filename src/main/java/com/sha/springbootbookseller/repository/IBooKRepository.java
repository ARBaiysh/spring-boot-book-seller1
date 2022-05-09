package com.sha.springbootbookseller.repository;

import com.sha.springbootbookseller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBooKRepository extends JpaRepository<Book, Long> {

}
