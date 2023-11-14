package com.green.greengram.feed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FeedPicsInsProcDto {
    private int ifeed;
    private List<String> pics;

}
