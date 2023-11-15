package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedFavProcDto {
    private int ifeed;
    private int iuser;
}
