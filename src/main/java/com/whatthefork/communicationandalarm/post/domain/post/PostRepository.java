package com.whatthefork.communicationandalarm.post.domain.post;

import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(Long id);

    Optional<Post> findByIdAndIsDeletedFalse(Long id);

    void saveViewLog(PostViewLog viewLog);

    long countViewsByPostId(Long postId);
}
