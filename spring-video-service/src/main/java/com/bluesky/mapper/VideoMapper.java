package com.bluesky.mapper;

import com.bluesky.domain.Video;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Blue_Sky 7/29/21
 */
@Repository
public interface VideoMapper {
    @Select("select * from video where id = #{videoId}")
    Video findById(int videoId);
}
