package com.example.book.repository;

import com.example.book.model.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBookRentRepository extends JpaRepository<BookRent, Integer> {
    @Query(value = "select * from book_rent as b where b.book_id = :id and b.code like :code limit 1",nativeQuery = true)
    Optional<BookRent> findBookRent(String code, int id);
}
