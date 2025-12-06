package com.whatthefork.communicationandalarm.common.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePostRequestDto {

    private Long memberId;

    private Boolean isAnnouncement;

    private String title;

    private String comment;
}
