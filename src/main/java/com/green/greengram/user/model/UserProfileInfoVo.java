package com.green.greengram.user.model;


import lombok.Data;


@Data
public class UserProfileInfoVo {
    private int feedCnt;
    private int favCnt;
    private String nm;
    private String createdAt;
}
