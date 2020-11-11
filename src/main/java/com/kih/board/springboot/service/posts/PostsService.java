package com.kih.board.springboot.service.posts;

import com.kih.board.springboot.domain.posts.Posts;
import com.kih.board.springboot.domain.posts.PostsRepository;
import com.kih.board.springboot.web.dto.PostsResponseDto;
import com.kih.board.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// final인 필드를 인자로 하는 생성자를 생성
@RequiredArgsConstructor
@Service
public class PostsService {
    // 생성자를 통한 빈 주입 방식
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        // 게시글 생성
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        // 게시글 업데이트, 여기서는 db에 따로 쿼리를 날리지 않았다. 트랜잭션 안에서 영속성 컨텍스트 유지되는 jpa 특성을 이용한 더티체킹 이라는 개념을 이용하여 업데이트
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }


    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        // 브라우저에서 json형태로 posts 정보를 보여주기 위해서 dto 리턴
        return new PostsResponseDto(entity);
    }

}
