package com.whatthefork.communicationandalarm.common.dto.response;

import com.whatthefork.communicationandalarm.post.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private Long id;
    private Long memberId;
    private Boolean isAnnouncement;
    private String title;
    private String content;
    private Integer viewCount;
    private Integer commentCount;
    private Boolean isPinned;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PostResponseDto from(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .memberId(post.getMemberId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
