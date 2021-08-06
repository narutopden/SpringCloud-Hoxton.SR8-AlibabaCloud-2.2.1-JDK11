package com.bluesky.controller;

import com.bluesky.domain.Video;
import com.bluesky.domain.VideoOrder;
import com.bluesky.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Blue_Sky 7/29/21
 */
@RestController
@RequestMapping("api/v1/video_order")
@RefreshScope
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private VideoService videoService;

    @Value("${video.title}")
    private String videoTitle;

    @RequestMapping("findById")
    public Object save(int videoId){
        //Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find_by_id?videoId=" + videoId, Video.class);

//        List<ServiceInstance> list = discoveryClient.getInstances("spring-video-service");

//        ServiceInstance serviceInstance = list.get(0);

//        Video video = restTemplate.getForObject("http://spring-video-service/api/v1/video/find_by_id?videoId=" + videoId, Video.class);

        //using open-feign
        Video video = videoService.findById(videoId);

        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(videoTitle);
        videoOrder.setCreateTime(new Date());
        videoOrder.setServerPort(video.getServerPort());
        return videoOrder;
    }


    /**
     * just for test save post method
     * @param video
     * @return
     */
    @RequestMapping("save")
    public Object saveVideo(@RequestBody Video video){
        int i = videoService.saveVideo(video);
        Map<String,Integer> map = new HashMap<>();
        map.put("mission", i);
        return map;
    }
    int tmp = 0;
    @RequestMapping("list")
    public Object list(HttpServletRequest request){
//        tmp++;
//        if (tmp%3==0){
//            throw new NullPointerException();
//        }
//        System.out.println(tmp);
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Map<String,String> map = new HashMap<>();
        map.put("port :",request.getServerPort()+"");
        map.put("mission:1 ", "kill the process");
        map.put("mission:2 ", "kill the process pre");

        return map.toString();
    }
}
