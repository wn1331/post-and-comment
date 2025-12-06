package com.whatthefork.communicationandalarm.post.domain.post;

import com.whatthefork.communicationandalarm.common.dto.request.CreatePostRequest;
import com.whatthefork.communicationandalarm.common.dto.request.GetPostsRequest;
import com.whatthefork.communicationandalarm.common.dto.request.UpdatePostRequest;
import com.whatthefork.communicationandalarm.common.dto.response.GetPostResponse;
import com.whatthefork.communicationandalarm.common.exception.ErrorCode;
import com.whatthefork.communicationandalarm.common.exception.GlobalException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void create(CreatePostRequest request, Long userId) {
        Post post = Post.create(
                userId,
                request.getCategory(),
                request.getTitle(),
                request.getContent()
        );
        postRepository.save(post);
    }

    @Transactional
    public void update(UpdatePostRequest request, Long userId) {
        Post post = postRepository.findByIdAndIsDeletedFalse(request.getPostId())
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        if (!post.isOwner(userId)) {
            throw new GlobalException(ErrorCode.POST_ACCESS_DENIED);
        }

        post.update(request.getTitle(), request.getContent(), request.getCategory());
    }

    @Transactional
    public void delete(Long postId, Long userId) {
        Post post = postRepository.findByIdAndIsDeletedFalse(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        if (!post.isOwner(userId)) {
            throw new GlobalException(ErrorCode.POST_ACCESS_DENIED);
        }

        post.delete();
    }

    @Transactional
    public List<Post> getPosts(GetPostsRequest request) {
        // 검색, 페이징, 검색은
        return null;
    }

    @Transactional
    public GetPostResponse getPost(Long postId, Long userId) {
        Post post = postRepository.findByIdAndIsDeletedFalse(postId)
                .orElseThrow(() -> new GlobalException(ErrorCode.POST_NOT_FOUND));

        PostViewLog viewLog = PostViewLog.create(userId, postId);
        postRepository.saveViewLog(viewLog);

        long viewCount = postRepository.countViewsByPostId(postId);

        return GetPostResponse.of(post, viewCount);
    }
}
