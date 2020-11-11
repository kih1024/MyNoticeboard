package com.kih.board.springboot.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 게시글 수정시 사용되는 dto. 제목과 내용만 수정.
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
