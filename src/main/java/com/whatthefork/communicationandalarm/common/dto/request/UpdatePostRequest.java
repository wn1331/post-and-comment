package com.whatthefork.communicationandalarm.common.dto.request;

import com.whatthefork.communicationandalarm.common.enums.Category;

public class UpdatePostRequest {

    private Long memberId;

    private Category category;

    private String title;

    private String content;

}
