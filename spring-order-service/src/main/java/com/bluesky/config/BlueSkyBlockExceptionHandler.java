package com.bluesky.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Blue_Sky 8/2/21
 */
@Component
public class BlueSkyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        Map<String,Object> info = new HashMap<>();
        if (e instanceof FlowException){
            info.put("code",-1);
            info.put("msg","Limit-Abnormal");
        }else if (e instanceof DegradeException){
            info.put("code",-2);
            info.put("msg","Downgrade-Abnormal");
        }else if (e instanceof ParamFlowException){
            info.put("code",-3);
            info.put("msg","Hot Spot-Abnormal");
        }else if (e instanceof SystemBlockException){
            info.put("code",-4);
            info.put("msg","System Rules-Abnormal");
        }else if (e instanceof AuthorityException){
            info.put("code",-5);
            info.put("msg","Authentication-Abnormal");
        }
        // json return
        httpServletResponse.setStatus(200);
        httpServletResponse.setHeader("content-Type","application/json; charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(info));
    }
}
