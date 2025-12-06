package com.whatthefork.communicationandalarm.common.dto.request;

import com.whatthefork.communicationandalarm.common.enums.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdatePostRequest {

    private Long postId;

    private Category category;

    private String title;

    private String content;
}
