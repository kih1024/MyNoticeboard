package com.kih.board.springboot.web;

import com.kih.board.springboot.service.posts.PostsService;
import com.kih.board.springboot.web.dto.PostsResponseDto;
import com.kih.board.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// 컨트롤러
@RequiredArgsConstructor // final인 필드를 인자로 하는 생성자를 생성
@RestController
public class PostsApiController {

    private final PostsService postsService; // 생성자를 통한 빈 주입 방식

    @PostMapping("/api/v1/posts") // 게시글을 추가할때 호출.
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") // 게시글을 수정할때 호출.
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") // 게시글을 조회할때 호출.
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }


}
