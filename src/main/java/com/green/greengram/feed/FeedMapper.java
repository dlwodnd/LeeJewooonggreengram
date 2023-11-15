package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {

    int insFeed(FeedInsProcDto dto);
    int insFeedPic(FeedPicsInsProcDto dto);
    List<FeedSelVo> selFeed(FeedSelDto dto);
    List<FeedPicsVo> selFeedPics(List<Integer> list);
    //t_favorite
    int delFeedFav(FeedFavProcDto dto);
    int insFeedFav(FeedFavProcDto dto);
}
