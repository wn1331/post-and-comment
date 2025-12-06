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
@AllArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    private String content;

    public Boolean isPinned = false;

    public Boolean isDeleted = false;
}
