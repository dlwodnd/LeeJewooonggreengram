package com.green.greengram.feed;

import com.green.greengram.ResVo;
import com.green.greengram.feed.model.FeedInsDto;
import com.green.greengram.feed.model.FeedSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResVo insFeed(@RequestBody FeedInsDto dto){
        System.out.println(dto);
        service.insFeed(dto);
        return null;
    }

    @GetMapping
    public List<FeedSelVo> getFeed(int page){
        System.out.println(page);
        return service.getFeed(page);
    }
}
