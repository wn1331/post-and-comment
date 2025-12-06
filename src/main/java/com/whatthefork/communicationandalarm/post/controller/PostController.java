package com.whatthefork.communicationandalarm.post.controller;

import com.whatthefork.communicationandalarm.post.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

}
