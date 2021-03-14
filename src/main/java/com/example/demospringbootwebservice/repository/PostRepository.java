package com.example.demospringbootwebservice.repository;


import com.example.demospringbootwebservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {

}
