package com.example.ss66.repository;

import com.example.ss66.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * FROM blog as b where UPPER(b.name) like concat(upper(:name),'%' )", nativeQuery = true)
    List<Blog> searchForName(@Param(value = "name") String name);
}
