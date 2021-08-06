package com.bluesky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Blue_Sky 7/29/21
 */
@MapperScan("com.bluesky.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class VideoApplication {
    public static void main(String args[]){
        SpringApplication.run(VideoApplication.class, args);
    }
}
