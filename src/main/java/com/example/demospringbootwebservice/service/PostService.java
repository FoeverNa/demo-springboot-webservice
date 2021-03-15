package com.example.demospringbootwebservice.service;

import com.example.demospringbootwebservice.domain.Posts;
import com.example.demospringbootwebservice.dto.PostListResponseDto;
import com.example.demospringbootwebservice.dto.PostUpdateRequestDto;
import com.example.demospringbootwebservice.dto.PostsResponseDto;
import com.example.demospringbootwebservice.dto.PostsSaveRequestsDto;
import com.example.demospringbootwebservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true) // 조회할때 트랜잭션범위 유지하면서 조회속도 개선
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllDesc().stream()
                .map((PostListResponseDto::new))
                .collect(Collectors.toList()); // Dto로 변환할때 Stream사용하기
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다"));
        //존재하는지 먼저 확인한 후 삭제
        postRepository.delete(posts);
    }
}
