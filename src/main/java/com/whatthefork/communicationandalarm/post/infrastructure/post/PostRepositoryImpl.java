package com.whatthefork.communicationandalarm.post.infrastructure.post;

import com.whatthefork.communicationandalarm.post.domain.post.Post;
import com.whatthefork.communicationandalarm.post.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostJpaRepository postJpaRepository;
    private final PostViewLogJpaRepository postViewLogJpaRepository;

    public Post save(Post post) {
        return postJpaRepository.save(post);
    }
}
