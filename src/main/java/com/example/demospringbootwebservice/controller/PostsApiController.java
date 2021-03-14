package com.example.demospringbootwebservice.controller;

import com.example.demospringbootwebservice.dto.PostsSaveRequestsDto;
import com.example.demospringbootwebservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long savePost(@RequestBody PostsSaveRequestsDto requestDto) {

        return postService.save(requestDto);
    }

}
