package com.bluesky.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Blue_Sky 7/29/21
 */
@Data
public class VideoOrder {
    private Integer id;
    private String outTradeNo;
    private Integer state;
    private Date createTime;
    private  Integer totalFee;
    private Integer videoId;
    private String videoTitle;
    private String videoImg;
    private Integer userId;

    private String serverPort;
}
