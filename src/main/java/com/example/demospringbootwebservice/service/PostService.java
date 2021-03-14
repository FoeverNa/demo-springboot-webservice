package com.example.demospringbootwebservice.service;

import com.example.demospringbootwebservice.domain.Posts;
import com.example.demospringbootwebservice.dto.PostUpdateRequestDto;
import com.example.demospringbootwebservice.dto.PostsResponseDto;
import com.example.demospringbootwebservice.dto.PostsSaveRequestsDto;
import com.example.demospringbootwebservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save (PostsSaveRequestsDto requsetDto) {
        return postRepository.save(requsetDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다"));

        //쿼리없이 객체 업데이트로 update가능
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다"));

        return new PostsResponseDto(entity);
    }

}
