package com.green.greengram.user;

import com.green.greengram.feed.model.FeedInsDto;
import com.green.greengram.feed.model.FeedPicsInsProcDto;
import com.green.greengram.user.model.UserInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    String selUserByUid(String uid);

}
