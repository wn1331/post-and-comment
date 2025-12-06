package com.whatthefork.communicationandalarm.post.infrastructure.post;

import com.whatthefork.communicationandalarm.post.domain.post.Post;
import com.whatthefork.communicationandalarm.post.domain.post.PostRepository;
import com.whatthefork.communicationandalarm.post.domain.post.PostViewLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostJpaRepository postJpaRepository;
    private final PostViewLogJpaRepository postViewLogJpaRepository;

    @Override
    public Post save(Post post) {
        return postJpaRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postJpaRepository.findById(id);
    }

    @Override
    public Optional<Post> findByIdAndIsDeletedFalse(Long id) {
        return postJpaRepository.findByIdAndIsDeletedFalse(id);
    }

    @Override
    public void saveViewLog(PostViewLog viewLog) {
        postViewLogJpaRepository.save(viewLog);
    }

    @Override
    public long countViewsByPostId(Long postId) {
        return postViewLogJpaRepository.countByPostId(postId);
    }
}
