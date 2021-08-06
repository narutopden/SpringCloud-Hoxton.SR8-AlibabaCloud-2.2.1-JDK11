package com.bluesky.service;

import com.bluesky.domain.Video;
import com.bluesky.service.fallback.VideoServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Blue_Sky 7/30/21
 */
@FeignClient(value = "spring-video-service", fallback = VideoServiceFallBack.class)
public interface VideoService {

    @GetMapping("/api/v1/video/find_by_id")
    Video findById(@RequestParam("videoId") int videoId);

    @PostMapping("/api/v1/video/save")
    int saveVideo(@RequestBody Video video);
}
