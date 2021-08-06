package com.bluesky.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Blue_Sky 7/29/21
 */
@Data
public class Video {
    private Integer id;
    private String title;
    private String summary;
    private String coverImg;
    private Integer  price;
    private Date createTime;
    private Double point;

    private String serverPort;
}
