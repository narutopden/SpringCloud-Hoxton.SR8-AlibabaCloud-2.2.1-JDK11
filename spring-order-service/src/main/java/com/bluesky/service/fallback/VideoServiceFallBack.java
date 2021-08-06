package com.bluesky.service.fallback;

import com.bluesky.domain.Video;
import com.bluesky.service.VideoService;
import org.springframework.stereotype.Service;

/**
 * @author Blue_Sky 8/2/21
 */
@Service
public class VideoServiceFallBack implements VideoService {
    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("video data from fallBack service");
        return video;
    }

    @Override
    public int saveVideo(Video video) {
        return 0;
    }
}
