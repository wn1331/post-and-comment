package com.whatthefork.communicationandalarm.post.controller;

import com.whatthefork.communicationandalarm.common.ApiResponse;
import com.whatthefork.communicationandalarm.common.dto.request.CreatePostRequest;
import com.whatthefork.communicationandalarm.common.dto.request.UpdatePostRequest;
import com.whatthefork.communicationandalarm.common.dto.response.GetPostResponse;
import com.whatthefork.communicationandalarm.common.resolver.UserId;
import com.whatthefork.communicationandalarm.post.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ApiResponse<Void> create(
            @UserId Long userId,
            @RequestBody CreatePostRequest request
    ) {
        postService.create(request, userId);
        return ApiResponse.success(null);
    }

    @PutMapping
    public ApiResponse<Void> update(
            @UserId Long userId,
            @RequestBody UpdatePostRequest request
    ) {
        postService.update(request, userId);
        return ApiResponse.success(null);
    }

    @DeleteMapping("/{postId}")
    public ApiResponse<Void> delete(
            @UserId Long userId,
            @PathVariable Long postId
    ) {
        postService.delete(postId, userId);
        return ApiResponse.success(null);
    }

    @GetMapping("/{postId}")
    public ApiResponse<GetPostResponse> getPost(
            @UserId Long userId,
            @PathVariable Long postId
    ) {
        GetPostResponse response = postService.getPost(postId, userId);
        return ApiResponse.success(response);
    }
}
