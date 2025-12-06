package com.whatthefork.communicationandalarm.post.domain.post;

import com.whatthefork.communicationandalarm.common.dto.request.CreatePostRequest;
import com.whatthefork.communicationandalarm.common.dto.request.GetPostsRequest;
import com.whatthefork.communicationandalarm.common.dto.request.UpdatePostRequest;
import com.whatthefork.communicationandalarm.common.dto.response.GetPostResponse;
import jakarta.transaction.TransactionScoped;
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
        // post 생성 후 저장(빌더패턴, 정적팩토리메서드 사용)
    }

    @Transactional
    public void update(UpdatePostRequest request, Long userId){
        // post Update

    }

    @Transactional
    public void delete(Long postId, Long userId){

        // postId로 post 삭제

    }

    @Transactional
    public List<Post> getPosts(GetPostsRequest request){
        // 검색, 페이징, 검색은
        return null;
    }

    @Transactional
    public GetPostResponse getPost(String postId){
        return null;
    }
}
