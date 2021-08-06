package com.bluesky.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Blue_Sky 7/29/21
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String headImg;
    private String phone;
    private Date createTime;
    private String wechat;
}
