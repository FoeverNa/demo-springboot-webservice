package com.example.demospringbootwebservice.repository;

import com.example.demospringbootwebservice.domain.Posts;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class postRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After("")
    void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("abcd@mail.com")
                .build());

        //when
        List<Posts> posts = postRepository.findAll();

        //then
        Posts post = posts.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    void BasetimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2020,03,17,0,0,0);
        postRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postList = postRepository.findAll();

        //then
        Posts posts = postList.get(0);

        System.out.println(">>>>>>>>>>> createDate="+posts.getCreateDate()
                +", modeifeidDate="+posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);


    }
}