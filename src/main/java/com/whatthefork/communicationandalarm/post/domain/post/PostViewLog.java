package com.whatthefork.communicationandalarm.post.domain.post;

import com.whatthefork.communicationandalarm.common.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostViewLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long postId;

    private PostViewLog(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public static PostViewLog create(Long userId, Long postId) {
        return new PostViewLog(userId, postId);
    }
}
