package com.green.greengram.feed.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class FeedInsProcDto {
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;

    public FeedInsProcDto(FeedInsDto dto){
        this.iuser = dto.getIuser();
        this.contents = dto.getContents();
        this.location = dto.getLocation();
    }

}
