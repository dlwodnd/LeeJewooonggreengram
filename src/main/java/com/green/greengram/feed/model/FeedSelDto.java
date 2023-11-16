package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedSelDto {
    private int loginedIuser; //로그인한 iuser
    private int targetIuser; //보고자하는 프로필 주인 iuser
    private int startIdx;
    private int rowCount;
}
