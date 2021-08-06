package com.bluesky.controller;

import com.bluesky.domain.Video;
import com.bluesky.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Blue_Sky 7/29/21
 */
@RestController
@RequestMapping("api/v1/video/")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @RequestMapping("find_by_id")
    public Object findById(int videoId, HttpServletRequest request){
        Video video = videoService.findById(videoId);
        video.setServerPort(request.getServerName()+":"+request.getServerPort());
        return video;
    }


    @PostMapping("save")
    public int saveVideo(@RequestBody Video video ){
        System.out.println(video.getTitle());
        return 1;
    }
}
