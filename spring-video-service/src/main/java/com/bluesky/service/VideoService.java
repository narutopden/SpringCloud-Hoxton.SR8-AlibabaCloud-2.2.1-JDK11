package com.bluesky.service;

import com.bluesky.domain.Video;

/**
 * @author Blue_Sky 7/29/21
 */
public interface VideoService {
    Video findById(int videoId);
}
