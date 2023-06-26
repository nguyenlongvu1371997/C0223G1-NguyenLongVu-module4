package com.example.ss66.repository;

import com.example.ss66.model.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogTypeRepository extends JpaRepository<BlogType, Integer> {
}
