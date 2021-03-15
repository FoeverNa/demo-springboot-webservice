package com.example.demospringbootwebservice.repository;


import com.example.demospringbootwebservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p From Posts p ORDER by p.id DESC")
    List<Posts> findAllDesc();
}
