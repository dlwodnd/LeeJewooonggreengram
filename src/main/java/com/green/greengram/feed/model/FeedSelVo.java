package com.green.greengram.feed.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private int iuser;
    private String writer;
    private String createdAt;
    private List<String> pics = new ArrayList<>();
    private int isFav;
}
