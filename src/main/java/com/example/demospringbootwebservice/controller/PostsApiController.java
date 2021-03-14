package com.example.demospringbootwebservice.controller;

import com.example.demospringbootwebservice.dto.PostUpdateRequestDto;
import com.example.demospringbootwebservice.dto.PostsResponseDto;
import com.example.demospringbootwebservice.dto.PostsSaveRequestsDto;
import com.example.demospringbootwebservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long savePost(@RequestBody PostsSaveRequestsDto requestDto) {

        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {

        return postService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {

        return postService.findById(id);
    }

}
