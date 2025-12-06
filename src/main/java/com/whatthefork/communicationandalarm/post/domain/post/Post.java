package com.whatthefork.communicationandalarm.post.domain.post;

import com.whatthefork.communicationandalarm.common.domain.BaseEntity;
import com.whatthefork.communicationandalarm.common.enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    private String content;

    private Boolean isPinned = false;

    private Boolean isDeleted = false;

    @Builder
    private Post(Long memberId, Category category, String title, String content) {
        this.memberId = memberId;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public static Post create(Long memberId, Category category, String title, String content) {
        return Post.builder()
                .memberId(memberId)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }

    public void update(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public void delete() {
        this.isDeleted = true;
    }

    public boolean isOwner(Long memberId) {
        return this.memberId.equals(memberId);
    }
}
