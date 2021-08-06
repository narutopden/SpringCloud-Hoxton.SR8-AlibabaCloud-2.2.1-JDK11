package com.bluesky.service.impl;

import com.bluesky.domain.Video;
import com.bluesky.mapper.VideoMapper;
import com.bluesky.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Blue_Sky 7/29/21
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public Video findById(int videoId) {
        return videoMapper.findById(videoId);
    }
}
