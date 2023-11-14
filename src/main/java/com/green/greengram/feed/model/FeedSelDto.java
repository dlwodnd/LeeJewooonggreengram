package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedSelDto {
    private int startIdx; //4
    private int rowCount; //4
}
