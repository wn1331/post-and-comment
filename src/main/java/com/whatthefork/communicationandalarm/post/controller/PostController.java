package com.whatthefork.communicationandalarm.post.controller;

import com.whatthefork.communicationandalarm.common.ApiResponse;
import com.whatthefork.communicationandalarm.common.dto.request.CreatePostRequest;
import com.whatthefork.communicationandalarm.post.domain.post.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;




    // 게시물 생성
    @GetMapping("/")
    public ApiResponse<Void> create(
        @RequestBody CreatePostRequest request,
        HttpServletRequest servletRequest
    ){
        Long userId = Long.valueOf(servletRequest.getHeader("X-User-Id")); // 게이트웨이가 넣어준 값
        postService.create(request, userId);
        return ApiResponse.success(null);
    }

    // 게시물 수정

    // 게시물 삭제

    // 게시물 단건조회

    // 게시물 리스트 조회(페이징, 검색 필터링)

}
