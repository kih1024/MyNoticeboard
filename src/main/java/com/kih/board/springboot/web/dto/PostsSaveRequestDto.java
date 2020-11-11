package com.kih.board.springboot.web.dto;

import com.kih.board.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// 게시글 추가 될때 사용되는 dto
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 빌드 패턴 사용. Repository의 save 메소드를 사용하기 위해서 필요한 엔티티 객체를 만들어서 해당 dto의 데이터를 넣어줘서 반환
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
