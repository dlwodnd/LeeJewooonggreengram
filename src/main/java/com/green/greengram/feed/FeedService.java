package com.green.greengram.feed;

import com.green.greengram.ResVo;
import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;

    public ResVo insFeed(FeedInsDto dto){
        FeedInsProcDto pDto = new FeedInsProcDto(dto);
        mapper.insFeed(pDto);
        FeedPicsInsProcDto p2Dt0 = new FeedPicsInsProcDto(pDto.getIfeed(),dto.getPics());
        mapper.insFeedPic(p2Dt0);
        return new ResVo(pDto.getIfeed());
    }
    public List<FeedSelVo> getFeed(int page,int loginedIuser,int targetIuser) {
        final int ROW_COUNT = 30;
        FeedSelDto dto = FeedSelDto.builder()
                .loginedIuser(loginedIuser)
                .targetIuser(targetIuser)
                .startIdx((page - 1) * ROW_COUNT)
                .rowCount(ROW_COUNT)
                .build();
        List<FeedSelVo> feedSelVoList = mapper.selFeed(dto);
        List<Integer> iFeedList = new ArrayList();
        Map<Integer, FeedSelVo> feedMap = new HashMap();
        for(FeedSelVo vo : feedSelVoList) {
            iFeedList.add(vo.getIfeed());
            feedMap.put(vo.getIfeed(), vo);
        }
        if(iFeedList.size() > 0) {
            List<FeedPicsVo> feedPicsList = mapper.selFeedPics(iFeedList);

            for(FeedPicsVo vo : feedPicsList) {

                FeedSelVo feedVo = feedMap.get(vo.getIfeed());
                feedVo.getPics().add(vo.getPic());

            }
        }
        return feedSelVoList;
    }

    public ResVo procFav(FeedFavProcDto dto){
        int result = mapper.delFeedFav(dto);
        if(result == 1){
            return new ResVo(2);
        }
        result = mapper.insFeedFav(dto);
        return new ResVo(result);
    }//좋아요 토글 기능
}