package com.example.demospringbootwebservice.service;

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

}
