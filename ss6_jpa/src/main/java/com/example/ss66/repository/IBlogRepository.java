package com.example.ss66.repository;

import com.example.ss66.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findBlogByNameContainingAndFlagDeleteIsFalse(String name);

    Page<Blog> findAllByFlagDeleteIsFalse(Pageable pageable);

    @Query(value = "SELECT * FROM blogs as b where b.type_of_blog_id = :id", nativeQuery = true)
    Page<Blog> findAllByTypeOfBlogIs(@Param(value = "id") int id, Pageable pageable);

    @Query(value = "SELECT * FROM blogs as b where b.type_of_blog_id = :id", nativeQuery = true)
    List<Blog> findAllByTypeOfBlogIs(@Param(value = "id") int id);

    @Query(value = "SELECT * FROM blogs limit :limit",nativeQuery = true)
    List<Blog> getBlogLimit(@Param(value = "limit") int limit);
}
